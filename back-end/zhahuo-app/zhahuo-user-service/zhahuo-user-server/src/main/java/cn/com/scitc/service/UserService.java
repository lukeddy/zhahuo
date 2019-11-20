package cn.com.scitc.service;

import cn.com.scitc.entity.ZhUser;
import cn.com.scitc.mapper.ZhUserMapper;
import cn.com.scitc.pojo.User;
import cn.com.scitc.utils.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private ZhUserMapper userMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;

    static final String KEY_PREFIX = "user:code:phone:";

    static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public ZhUser queryAdminOne(String username, String password) {
        ZhUser user = new ZhUser();
        user.setTelephone(username);
        user.setPassword(password);
        ZhUser result = userMapper.selectOne(user);
        System.out.println(result);
        return result;
    }

    public Boolean sendVerifyCode(String phone) {
        // 生成验证码
        String code = NumberUtils.generateCode(6);
        try {
            // 发送短信
            Map<String, String> msg = new HashMap<>();
            msg.put("phone", phone);
            msg.put("code", code);
            // 将code存入redis
            this.amqpTemplate.convertAndSend("ms.sms.exchange", "sms.verify.code", msg);
            this.stringRedisTemplate.opsForValue().set(KEY_PREFIX + phone, code, 5, TimeUnit.MINUTES);
            System.out.println(this.stringRedisTemplate.opsForValue().get(KEY_PREFIX + phone));
            return true;
        } catch (Exception e) {
            logger.error("发送短信失败。phone：{}， code：{}", phone, code);
            return false;
        }
    }
    public List<ZhUser> selectUser(){
     return  userMapper.selectAll();
    }


    public Boolean register(User user) {
        //获取验证码的key
        String key = KEY_PREFIX + user.getPhone();
        //从redis取出验证码
        String codeCache = this.stringRedisTemplate.opsForValue().get(key);
        System.out.println(codeCache + ":" + user.getCode());
        //检查验证码是否正确
        if (!user.getCode().equals(codeCache)) {
            // 不正确，返回
            return false;
        }
        System.out.println(user.getCode());
        //user.setCreated(new Date());
        // 生成盐
        //String salt = CodecUtils.generateSalt();
        //user.setSalt(salt);
        // 对密码进行加密
//        admin.setAdminPwd(DigestUtils.md5Hex(admin.getAdminPwd()));
        //user.setPassword(CodecUtils.md5Hex(user.getPassword(), salt));
        // 写入数据库
        ZhUser zhUser = new ZhUser();
        zhUser.setTelephone(user.getPhone());
        zhUser.setUsername(user.getPhone());
        zhUser.setPassword(user.getPassword());
        zhUser.setName(user.getPhone());
        boolean boo = this.userMapper.insertSelective(zhUser) == 1;

        // 如果注册成功，删除redis中的code
        if (boo) {
            try {
                this.stringRedisTemplate.delete(key);
                System.out.println("success");
            } catch (Exception e) {
                logger.error("删除缓存验证码失败，code：{}", user.getCode(), e);
            }
        }
        return boo;
    }
}
