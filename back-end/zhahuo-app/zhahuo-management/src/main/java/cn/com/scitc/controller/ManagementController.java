package cn.com.scitc.controller;

import cn.com.scitc.entity.ZhOrder;
import cn.com.scitc.entity.ZhProduct;
import cn.com.scitc.entity.ZhUser;
import cn.com.scitc.page.PageResult;
import cn.com.scitc.pojo.PageResultPojo;
import cn.com.scitc.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.CodeSource;
import java.util.logging.ConsoleHandler;

@RestController
public class ManagementController {
    @Autowired
    private ManagementService managementService;
    @RequestMapping("li")
    public String li(){
        return "sucess";
    }
    @RequestMapping(value = "productPage")
    public ResponseEntity<PageResult<ZhProduct>> findProductPage(
            @RequestBody PageResultPojo page,
            String product
    ){
        System.out.println(page.toString());
        PageResult<ZhProduct> result = managementService.findProductByPage(page.getPage(),page.getRows(),page.getSortBy(),page.getDesc(),page.getKey());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    @RequestMapping(value = "orderPage")
    public ResponseEntity<PageResult<ZhOrder>> findOrderPage(
            @RequestBody PageResultPojo page,
            String order
    ){
        System.out.println(page.toString());
        PageResult<ZhOrder> result = managementService.findOrderByPage(page.getPage(),page.getRows(),page.getSortBy(),page.getDesc(),page.getKey());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @RequestMapping(value = "userPage")
    public ResponseEntity<PageResult<ZhUser>> findUserPage(
            @RequestBody PageResultPojo page,
            String user
    ){
        System.out.println(page.toString());
        PageResult<ZhUser> result = managementService.findUserByPage(page.getPage(),page.getRows(),page.getSortBy(),page.getDesc(),page.getKey());
        System.out.println(result);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
