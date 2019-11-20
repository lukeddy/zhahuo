package cn.com.scitc.service;

import cn.com.scitc.api.UserLogin;
import cn.com.scitc.entity.UserInfo;
import cn.com.scitc.entity.ZhUser;
import cn.com.scitc.jwtproperties.JWTProperties;
import cn.com.scitc.myexception.MyException;
import cn.com.scitc.myexception.ZhahuoExceptionEnum;
import cn.com.scitc.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.scitc.utils.JwtUtils;

import java.io.Console;

@Service
public class AuthService {
    @Autowired
    private UserLogin userLogin;



    @Autowired
    private JWTProperties jwtProperties;

    public ResponseData login(String username, String password) {
        //校验用户名和密码
        ZhUser zhUser = userLogin.queryAdminOne(username, password);
        ResponseData responseData = ResponseData.ok();
        if(zhUser == null){
            ResponseData responseData1 = ResponseData.notFound();
            System.out.println(responseData1.toString());
            return responseData1;
        }
        zhUser.setPassword("*****");
        try {

            //生成token
            String token = JwtUtils.generateToken(new UserInfo(zhUser.getUid(),username),jwtProperties.getPrivateKey(), jwtProperties.getExpire());

            responseData.putDataValue("token",token);
            responseData.putDataValue("admin",zhUser);
            return responseData;
        }catch (Exception e){
            throw new MyException(ZhahuoExceptionEnum.LOGIN_ERROR);
        }
    }
}
