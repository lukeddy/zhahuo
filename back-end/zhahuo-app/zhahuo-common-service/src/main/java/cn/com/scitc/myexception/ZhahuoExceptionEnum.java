package cn.com.scitc.myexception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ZhahuoExceptionEnum {
    //公共模块
    RESULT_IS_NULL(400,"返回结果为空!"),
    //登录注册模块
    PASSWORD_NOT_NULL(400,"密码不能为空！"),
    PHONE_NOT_NULL(400,"手机号码不能为空!"),
    LOGIN_INFO_NOt_NULL(400,"登录信息不完整!"),
    USERNAME_OR_PASSWORD_ERROR(500,"用户名或密码错误!"),
    LOGIN_ERROR(500,"登录异常!!!"),
    PHONE_SEND_ERROR(500,"短信发送失败!"),
    PHONE_SEND_SUCCESS(200,"短信发送成功!"),
    PAY_ERROR(500,"支付失败")
    ;
    private int statusCode;
    private String msg;
}
