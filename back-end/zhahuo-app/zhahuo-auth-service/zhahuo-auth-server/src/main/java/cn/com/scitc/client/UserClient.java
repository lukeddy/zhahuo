package cn.com.scitc.client;

import cn.com.scitc.api.UserLogin;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("zhahuo-user-server")
public interface UserClient extends UserLogin {
}
