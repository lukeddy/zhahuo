package cn.com.scitc.api;

import cn.com.scitc.entity.ZhUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("user")
public interface UserLogin {
    @RequestMapping("findUserInf")
    ZhUser queryAdminOne(@RequestParam("username") String username, @RequestParam("password") String password);

}
