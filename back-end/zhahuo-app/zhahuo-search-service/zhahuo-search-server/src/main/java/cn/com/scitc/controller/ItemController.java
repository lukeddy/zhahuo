package cn.com.scitc.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import cn.com.scitc.entity.ZhImage;
import cn.com.scitc.pojo.CatePojo;
import cn.com.scitc.result.ProductItemResult;
import cn.com.scitc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("image")
    public ResponseEntity<List<ZhImage>> queryImage(){
        List<ZhImage> images = itemService.queryImage();
        return  ResponseEntity.status(HttpStatus.OK).body(images);
    }

    @RequestMapping("ProductInf")
    public ResponseEntity<ProductItemResult> selectProductInfByPid(@RequestBody CatePojo catePojo){
        ProductItemResult result = itemService.selectProductInfByPid(catePojo.getPid());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
