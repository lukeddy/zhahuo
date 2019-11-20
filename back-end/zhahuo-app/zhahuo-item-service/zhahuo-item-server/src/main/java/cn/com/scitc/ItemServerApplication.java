package cn.com.scitc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("cn.com.scitc.mapper")
public class ItemServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemServerApplication.class,args);
    }
}
