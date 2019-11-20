package cn.com.scitc.service;

import cn.com.scitc.api.ItemProductQuery;
import cn.com.scitc.entity.ZhProduct;
import cn.com.scitc.mapper.ZhProductMapper;
import cn.com.scitc.pojo.CategoryPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {
    @Resource
    private ZhProductMapper productMapper;

    @Autowired
    private ItemProductQuery productQuery;

    public List<ZhProduct> searchProduct(String key) {
        //使用通用mapper进行模糊查询
        Example example = new Example(ZhProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("pname","%"+ key + "%");
        List<ZhProduct> zhProducts = productMapper.selectByExample(example);
        return zhProducts;
    }

    public List<ZhProduct> selectProduct(){
        List<ZhProduct> zhProducts = productMapper.selectAll();
        return zhProducts;
    }

    public ZhProduct selectOneProduct(String pid){
        ZhProduct zhProduct = productMapper.selectByPrimaryKey(pid);
        return zhProduct;
    }

    public List<ZhProduct> selectAllByCid(String cname) {
        CategoryPojo pojo = new CategoryPojo();
        pojo.setCname(cname);
        ResponseEntity<Integer> integerResponseEntity = productQuery.selectOneByCname(pojo);
        Example example = new Example(ZhProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cid",integerResponseEntity.getBody());
        return productMapper.selectByExample(example);
    }

    public List<ZhProduct> selectAllByBid(String bname) {
        CategoryPojo pojo = new CategoryPojo();
        pojo.setBname(bname);
        ResponseEntity<Integer> integerResponseEntity = productQuery.selectOneByBname(pojo);
        Example example = new Example(ZhProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bid", integerResponseEntity.getBody());
        return productMapper.selectByExample(example);
    }

    public List<ZhProduct> selectByCid(Integer cid) {
        Example example = new Example(ZhProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("cid",cid);
        return productMapper.selectByExample(example);
    }

    public List<ZhProduct> selectByBid(Integer bid) {
        Example example = new Example(ZhProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bid",bid);
        return productMapper.selectByExample(example);
    }

    public ZhProduct selectByPid(Integer pid) {
        ZhProduct product = productMapper.selectByPrimaryKey(pid);
        return product;
    }

    public List<ZhProduct> selectByKeyword(String keyword) {
        Example example = new Example(ZhProduct.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("pname","%"+ keyword + "%");
        return productMapper.selectByExample(example);
    }
}
