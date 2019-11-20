package cn.com.scitc.service;

import cn.com.scitc.entity.ZhCategory;
import cn.com.scitc.entity.ZhCategoryTow;
import cn.com.scitc.mapper.ZhCategoryMapper;
import cn.com.scitc.mapper.ZhCategoryTowMapper;
import cn.com.scitc.result.ItemResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Resource
    private ZhCategoryMapper categoryMapper;
    @Resource
    private ZhCategoryTowMapper categoryTowMapper;

    public List<ItemResult> getCateGory(){

        //用来封装所有数据
        List<ItemResult> list = new ArrayList<>();
        //查询一级菜单所有数据
        List<ZhCategory> zhCategories = categoryMapper.selectAll();
        //遍历一级菜单
        for(ZhCategory zhCategory: zhCategories){
            ZhCategoryTow categoryTow = new ZhCategoryTow();
            categoryTow.setCid(zhCategory.getCid());
            //获取二级菜单
            List<ZhCategoryTow> select = categoryTowMapper.select(categoryTow);
            //用来封装每一条数据
            ItemResult result = new ItemResult();
            result.setCid(zhCategory.getCid());
            result.setCname(zhCategory.getCname());
            result.setZhCategoryTow(select);
            System.out.println(result);
            System.out.println(list);
            list.add(result);
            if(list.size() == 33){
                break;
            }
        }
        return list;
    }

    public Integer selectByBname(String bname) {
        ZhCategoryTow categoryTow = new ZhCategoryTow();
        categoryTow.setBname(bname);
        ZhCategoryTow categoryTow1 = categoryTowMapper.selectOne(categoryTow);
        return categoryTow1.getBid();
    }

    public Integer selectByCname(String cname) {
        ZhCategory category = new ZhCategory();
        category.setCname(cname);
        ZhCategory zhCategory = categoryMapper.selectOne(category);
        return zhCategory.getCid();
    }
}
