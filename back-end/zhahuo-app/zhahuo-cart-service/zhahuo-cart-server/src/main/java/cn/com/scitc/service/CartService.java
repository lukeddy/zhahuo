package cn.com.scitc.service;

import cn.com.scitc.entity.ZhCart;
import cn.com.scitc.mapper.ZhCartMapper;
import cn.com.scitc.pojo.OrderPojo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CartService {
    @Resource
    private ZhCartMapper cartMapper;

    public String saveCartList(List<OrderPojo> orderPojo) {
        for(OrderPojo orderPojo1:orderPojo){
            ZhCart cart = new ZhCart();
            cart.setCartProductColor(orderPojo1.getColor());
            cart.setCartProductCount(orderPojo1.getCount());
            cart.setCartProductMp(orderPojo1.getMarketPrice());
            cart.setCartProductName(orderPojo1.getPname());
            cart.setCartProductSize(orderPojo1.getSize());
            cart.setPid(orderPojo1.getPid());
            cart.setUid(orderPojo1.getUid());
            cart.setCartProductImage(orderPojo1.getPimage());
            int insert = cartMapper.insert(cart);
        }
        return "success";
    }

    public List<ZhCart> findCartByUid(OrderPojo orderPojo) {
        Example example = new Example(ZhCart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uid",orderPojo.getUid());
        List<ZhCart> zhCarts = cartMapper.selectByExample(example);
        return zhCarts;
    }

    public String deleteById(ZhCart cart) {
        int i = cartMapper.deleteByPrimaryKey(cart.getCartId());
        return "success";
    }

    public String saveByCart(OrderPojo orderPojo) {
        ZhCart saveCart = new ZhCart();
        saveCart.setCartId(orderPojo.getCartId());
        saveCart.setCartProductColor(orderPojo.getColor());
        saveCart.setCartProductCount(orderPojo.getCount());
        saveCart.setCartProductMp(orderPojo.getMarketPrice());
        saveCart.setCartProductName(orderPojo.getPname());
        saveCart.setCartProductSize(orderPojo.getSize());
        saveCart.setPid(orderPojo.getPid());
        saveCart.setUid(orderPojo.getUid());
        saveCart.setCartProductImage(orderPojo.getPimage());
        System.out.println(saveCart);
        int i = cartMapper.updateByPrimaryKey(saveCart);
        return "success";
    }

    public String addCart(OrderPojo orderPojo) {
        Example example = new Example(ZhCart.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("pid",orderPojo.getPid());
        criteria.andEqualTo("uid",orderPojo.getUid());
        List<ZhCart> zhCarts = cartMapper.selectByExample(example);
        if(zhCarts != null){
            System.out.println("null");
            for(ZhCart cart: zhCarts){
                System.out.println(cart.getCartProductSize().equals(orderPojo.getSize()));
                if(cart.getCartProductSize().equals(orderPojo.getSize()) && cart.getCartProductColor().equals(orderPojo.getColor())){
                    Example example1 = new Example(ZhCart.class);
                    Example.Criteria criteria1 = example1.createCriteria();
                    criteria1.andEqualTo("cartProductSize",orderPojo.getSize());
                    criteria1.andEqualTo("cartProductColor",orderPojo.getColor());
                    criteria1.andEqualTo("pid",orderPojo.getPid());
                    criteria1.andEqualTo("uid",orderPojo.getUid());
                    List<ZhCart> zhCarts1 = cartMapper.selectByExample(example1);
                    System.out.println("*****");
                    System.out.println(zhCarts1);
                    for(ZhCart zhCart:zhCarts1){
                        zhCart.setCartProductCount(zhCart.getCartProductCount() + orderPojo.getCount());
                        cartMapper.updateByExample(zhCart,example1);
                    }
                    return "success";
                }
            }
        }
        ZhCart saveCart = new ZhCart();
        saveCart.setCartProductColor(orderPojo.getColor());
        saveCart.setCartProductCount(orderPojo.getCount());
        saveCart.setCartProductMp(orderPojo.getMarketPrice());
        saveCart.setCartProductName(orderPojo.getPname());
        saveCart.setCartProductSize(orderPojo.getSize());
        saveCart.setPid(orderPojo.getPid());
        saveCart.setUid(orderPojo.getUid());
        saveCart.setCartProductImage(orderPojo.getPimage());
        int insert = cartMapper.insert(saveCart);
        System.out.println(insert);
        return "success";
    }
}
