package cn.com.scitc.listener;

import cn.com.scitc.pojo.SmsProperties;
import cn.com.scitc.utils.SmsUtils;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmsListener {

    @Autowired
    private SmsUtils smsUtils;

    @Autowired
    private SmsProperties smsProperties;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "ms.sms.queue",durable = "true"),
            exchange = @Exchange(value = "ms.sms.exchange",ignoreDeclarationExceptions = "true"),
            key = {"sms.verify.code"}
    ))

    public void listenSms(Map<String,String> msg){
        System.out.println(msg.get("phone") + msg.get("code"));
        if (msg == null || msg.size() <= 0){
            System.out.println("No make");
            //不做处理
            return;
        }
        String phone = msg.get("phone");
        String code = msg.get("code");

        if (StringUtils.isNotBlank(phone) && StringUtils.isNotBlank(code)){
            //发送消息
            try {
                SendSmsResponse response = this.smsUtils.sendSms(phone, code, smsProperties.getSignName(), smsProperties.getVerifyCodeTemplate());
            }catch (ClientException e){
                return;
            }
        }else {
            //不做处理
            return;
        }
    }
}

