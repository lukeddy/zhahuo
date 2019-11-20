package cn.com.scitc.controller;

import cn.com.scitc.entity.ZhProduct;
import cn.com.scitc.page.PageResult;
import cn.com.scitc.pojo.PageResultPojo;
import cn.com.scitc.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("page")
public class PageController {

    @Autowired
    private PageService pageService;

    @RequestMapping(value = "productPage")
    public ResponseEntity<PageResult<ZhProduct>> findProductPage(
            @RequestBody PageResultPojo page
            ){
        System.out.println(page.toString());
        PageResult<ZhProduct> result = pageService.findByPage(page.getPage(),page.getRows(),page.getSortBy(),page.getDesc(),page.getKey());
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
