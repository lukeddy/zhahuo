package cn.com.scitc.controller;

import cn.com.scitc.entity.ZhCart;
import cn.com.scitc.pojo.OrderPojo;
import cn.com.scitc.service.CartService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @RequestMapping("saveCartList")
    public ResponseEntity<String> saveCartList(@RequestBody List<OrderPojo> orderPojoList){
        System.out.println(orderPojoList);
        String s = cartService.saveCartList(orderPojoList);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

    @RequestMapping("findCartByUid")
    public ResponseEntity<List<ZhCart>> findCartByUid(@RequestBody OrderPojo orderPojo){
        System.out.println(orderPojo);
        List<ZhCart> cartByUid = cartService.findCartByUid(orderPojo);
        return ResponseEntity.status(HttpStatus.OK).body(cartByUid);
    }

    @RequestMapping("deleteById")
    public ResponseEntity<String> deleteById(@RequestBody ZhCart cart){
        String s = cartService.deleteById(cart);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

    @RequestMapping("saveByCart")
    public ResponseEntity<String> saveByCart(@RequestBody OrderPojo orderPojo){
        System.out.println(orderPojo);
        System.out.println(1111);
        String s = cartService.saveByCart(orderPojo);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

    @RequestMapping("addCart")
    public ResponseEntity<String> addCart(@RequestBody OrderPojo orderPojo){
        System.out.println(orderPojo);
        String s = cartService.addCart(orderPojo);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }
}
