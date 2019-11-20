package cn.com.scitc.controller;

import cn.com.scitc.entity.ZhProduct;
import cn.com.scitc.pojo.CatePojo;
import cn.com.scitc.pojo.ProductPojo;
import cn.com.scitc.pojo.SearchPojo;
import cn.com.scitc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("search")
    public ResponseEntity<List<ZhProduct>> searchProduct(@RequestBody ProductPojo productPojo){
        List<ZhProduct> zhProducts = productService.searchProduct(productPojo.getCname());

        return ResponseEntity.status(HttpStatus.OK).body(zhProducts);
    }

    @RequestMapping("list")
    public ResponseEntity<List<ZhProduct>> selectProduct(){
        List<ZhProduct> zhProducts = productService.selectProduct();
        return ResponseEntity.status(HttpStatus.OK).body(zhProducts);
    }

    @RequestMapping("item")
    public ResponseEntity<ZhProduct> selectOneProduct(String pid){
        ZhProduct zhProduct = productService.selectOneProduct(pid);
        return ResponseEntity.status(HttpStatus.OK).body(zhProduct);
    }

    //更具bid 和 cid查询
    @RequestMapping("category")
    public ResponseEntity<List<ZhProduct>> selectAllByCid(@RequestBody ProductPojo productPojo){
        System.out.println(productPojo.getCname());
        List<ZhProduct> zhProducts = productService.selectAllByCid(productPojo.getCname());

        return ResponseEntity.status(HttpStatus.OK).body(zhProducts);
    }

    @RequestMapping("brand")
    public ResponseEntity<List<ZhProduct>> selectAllByBid(@RequestBody ProductPojo productPojo){
        List<ZhProduct> zhProducts = productService.selectAllByBid(productPojo.getBname());
        return ResponseEntity.status(HttpStatus.OK).body(zhProducts);
    }

    @RequestMapping("cid")
    public ResponseEntity<List<ZhProduct>> selectByCid(@RequestBody CatePojo categoryPojo){
        List<ZhProduct> zhProducts = productService.selectByCid(categoryPojo.getCid());
        return ResponseEntity.status(HttpStatus.OK).body(zhProducts);
    }

    @RequestMapping("bid")
    public ResponseEntity<List<ZhProduct>> selectByBid(@RequestBody CatePojo categoryPojo){
        List<ZhProduct> zhProducts = productService.selectByBid(categoryPojo.getBid());
        return ResponseEntity.status(HttpStatus.OK).body(zhProducts);
    }

    @RequestMapping("pid")
    public ResponseEntity<ZhProduct> selectByPid(@RequestBody CatePojo catePojo){
        ZhProduct product = productService.selectByPid(catePojo.getPid());
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    @RequestMapping("keyword")
    public  ResponseEntity<List<ZhProduct>> selectByKeyword(@RequestBody SearchPojo searchPojo){
        List<ZhProduct> zhProducts = productService.selectByKeyword(searchPojo.getKeyword());
        return ResponseEntity.status(HttpStatus.OK).body(zhProducts);
    }
}
