package cn.com.scitc.controller;

import cn.com.scitc.entity.ZhUser;
import cn.com.scitc.myexception.MyException;
import cn.com.scitc.myexception.ZhahuoExceptionEnum;
import cn.com.scitc.pojo.Phone;
import cn.com.scitc.pojo.User;
import cn.com.scitc.service.UserService;
import cn.com.scitc.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("findUserInf")
    public ResponseEntity<ZhUser> queryAdminOne(
            @RequestParam("username") String username,
            @RequestParam("password") String password){
        ZhUser zhUser = userService.queryAdminOne(username, password);
        return ResponseEntity.status(HttpStatus.OK).body(zhUser);
    }

    @RequestMapping("registerCode")
    public ResponseEntity<ZhahuoExceptionEnum> sendVerifyCode(@RequestBody Phone phone) {
        System.out.println(phone.getPhone());
        if (phone.getPhone() == "") {
            throw new MyException(ZhahuoExceptionEnum.PHONE_NOT_NULL);
        }
        //发送服务
        Boolean boo = this.userService.sendVerifyCode(phone.getPhone());

        if (boo == false || !boo){
            throw new MyException(ZhahuoExceptionEnum.PHONE_SEND_ERROR);
        }
        return ResponseEntity.status(HttpStatus.OK).body(ZhahuoExceptionEnum.PHONE_SEND_SUCCESS);
    }
    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody User user) {
        System.out.println(user);
        if(user.getPhone() == "" || user.getCode() == "" || user.getPassword() == ""){
            System.out.println("111111111111");
            return ResponseEntity.status(HttpStatus.OK).body("notfound");
        }
        Boolean boo = this.userService.register(user);
        if (boo == null || !boo) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }
}
