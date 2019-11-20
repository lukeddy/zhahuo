package cn.com.scitc.service;

import cn.com.scitc.entity.ZhImage;
import cn.com.scitc.entity.ZhProduct;
import cn.com.scitc.mapper.ZhImageMapper;
import cn.com.scitc.mapper.ZhProductMapper;
import cn.com.scitc.result.ProductItemResult;
import net.bytebuddy.description.field.FieldDescription;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemService {
    @Resource
    private ZhImageMapper imageMapper;

    @Resource
    private ZhProductMapper productMapper;
    public List<ZhImage> queryImage() {
        return imageMapper.selectAll();
    }

    public ProductItemResult selectProductInfByPid(Integer pid) {
        ZhProduct product = productMapper.selectByPrimaryKey(pid);
        Example example = new Example(ZhImage.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pid",pid);
        ZhImage zhImage = imageMapper.selectOneByExample(example);
        ProductItemResult result = new ProductItemResult();
        result.setProduct(product);
        result.setImage(zhImage);
        return result;
    }
}
