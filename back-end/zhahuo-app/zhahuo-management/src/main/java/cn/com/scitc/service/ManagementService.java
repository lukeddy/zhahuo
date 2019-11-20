package cn.com.scitc.service;

import cn.com.scitc.entity.ZhOrder;
import cn.com.scitc.entity.ZhProduct;
import cn.com.scitc.entity.ZhUser;
import cn.com.scitc.mapper.ZhOrderMapper;
import cn.com.scitc.mapper.ZhProductMapper;
import cn.com.scitc.mapper.ZhUserMapper;
import cn.com.scitc.page.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
@Service
public class ManagementService {
    @Resource
    private ZhOrderMapper orderMapper;
    @Resource
    private ZhProductMapper productMapper;
    @Resource
    private ZhUserMapper userMapper;

    public PageResult<ZhProduct> findProductByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key){
        //开始分页  参数表示当前页，以及每页数据量
        PageHelper.startPage(page,rows);
        //过滤
        Example example = new Example(ZhProduct.class);
        if(StringUtils.isNotBlank(sortBy)){
            System.out.println(sortBy);
            System.out.println(desc);
            String orderByClause = sortBy +(desc ? "DESC" : "ASC");
            example.setOrderByClause(orderByClause);
        }
        //查询
        Page<ZhProduct> pageResult = (Page<ZhProduct>) productMapper.selectByExample(example);

        //返回结果
        return new PageResult<>(pageResult.getTotal(),pageResult.getPages(),pageResult.getPageNum(),pageResult);
    }
    public PageResult<ZhOrder> findOrderByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key){
        //开始分页  参数表示当前页，以及每页数据量
        PageHelper.startPage(page,rows);
        //过滤
        Example example = new Example(ZhOrder.class);
        if(StringUtils.isNotBlank(sortBy)){
            System.out.println(sortBy);
            System.out.println(desc);
            String orderByClause = sortBy +(desc ? "DESC" : "ASC");
            example.setOrderByClause(orderByClause);
        }
        //查询
        Page<ZhOrder> pageResult = (Page<ZhOrder>) orderMapper.selectByExample(example);

        //返回结果
        return new PageResult<>(pageResult.getTotal(),pageResult.getPages(),pageResult.getPageNum(),pageResult);
    }

    public PageResult<ZhUser> findUserByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key){
        //开始分页  参数表示当前页，以及每页数据量
        PageHelper.startPage(page,rows);
        //过滤
        Example example = new Example(ZhUser.class);
        if(StringUtils.isNotBlank(sortBy)){
            System.out.println(sortBy);
            System.out.println(desc);
            String orderByClause = sortBy +(desc ? "DESC" : "ASC");
            example.setOrderByClause(orderByClause);
        }
        //查询
        Page<ZhUser> pageResult = (Page<ZhUser>) userMapper.selectByExample(example);

        //返回结果
        return new PageResult<>(pageResult.getTotal(),pageResult.getPages(),pageResult.getPageNum(),pageResult);
    }
}
