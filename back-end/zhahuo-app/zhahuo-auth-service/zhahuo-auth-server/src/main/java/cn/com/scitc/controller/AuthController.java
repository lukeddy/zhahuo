package cn.com.scitc.controller;

import cn.com.scitc.entity.LoginJsonDate;
import cn.com.scitc.jwtproperties.JWTProperties;
import cn.com.scitc.myexception.MyException;
import cn.com.scitc.myexception.ZhahuoExceptionEnum;
import cn.com.scitc.service.AuthService;
import cn.com.scitc.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<ResponseData> login(
            @RequestBody LoginJsonDate loginJsonDate,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse){
        System.out.println(loginJsonDate.getUsername() + loginJsonDate.getPassword());
        if(loginJsonDate.getPassword() == null || loginJsonDate.getUsername() == null){
            throw new MyException(ZhahuoExceptionEnum.LOGIN_INFO_NOt_NULL);
        }
        //登录
        ResponseData loginResult = authService.login(loginJsonDate.getUsername(),loginJsonDate.getPassword());

        return ResponseEntity.status(HttpStatus.OK).body(loginResult);
    }
}
