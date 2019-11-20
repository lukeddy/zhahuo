package cn.com.scitc.controller;

import cn.com.scitc.pojo.CategoryPojo;
import cn.com.scitc.result.ItemResult;
import cn.com.scitc.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @RequestMapping("category")
    public ResponseEntity<List<ItemResult>> getCateGory(){
        ObjectMapper objectMapper = new ObjectMapper();
        List<ItemResult> cateGory = itemService.getCateGory();
        return ResponseEntity.status(HttpStatus.OK).body(cateGory);
    }

    @RequestMapping("bname")
    public ResponseEntity<Integer> selectOneByBname(@RequestBody CategoryPojo categoryPojo){
        Integer bid = itemService.selectByBname(categoryPojo.getBname());
        return ResponseEntity.status(HttpStatus.OK).body(bid);
    }
    @RequestMapping("cname")
    public ResponseEntity<Integer> selectOneByCname(@RequestBody CategoryPojo categoryPojo){
        Integer cid = itemService.selectByCname(categoryPojo.getCname());
        return ResponseEntity.status(HttpStatus.OK).body(cid);
    }
}
