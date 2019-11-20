package cn.com.scitc.api;

import cn.com.scitc.pojo.CategoryPojo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("item")
public interface ItemProductQuery {
    @RequestMapping("bname")
    ResponseEntity<Integer> selectOneByBname(@RequestBody CategoryPojo categoryPojo);

    @RequestMapping("cname")
    ResponseEntity<Integer> selectOneByCname(@RequestBody CategoryPojo categoryPojo);
}
