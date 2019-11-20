package cn.com.scitc.service;

import cn.com.scitc.config.AlipayConfig;
import cn.com.scitc.entity.ZhOrder;
import cn.com.scitc.entity.ZhOrderitem;
import cn.com.scitc.mapper.ZhOrderMapper;
import cn.com.scitc.mapper.ZhOrderitemMapper;
import cn.com.scitc.myexception.MyException;
import cn.com.scitc.myexception.ZhahuoExceptionEnum;
import cn.com.scitc.pojo.OrderPojo;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Resource
    private ZhOrderMapper orderMapper;

    @Resource
    private ZhOrderitemMapper orderitemMapper;

    public int text(){
       return orderMapper.selectCount(new ZhOrder());
    }

    public String orderServer(List<OrderPojo> orderPojoList){
        //保存订单信息
        ZhOrder order = new ZhOrder();
        Double total = 0.0;
        Integer uid = null;
        for(OrderPojo orderPojo: orderPojoList){
        total += orderPojo.getCount() * orderPojo.getMarketPrice();
        uid = orderPojo.getUid();
        }
        order.setState(0);
        order.setOrdertime(new Date());
        order.setUid(uid);
        order.setTotal(total);
        int insert = orderMapper.insert(order);

        for(OrderPojo orderPojo:orderPojoList){
            ZhOrderitem orderitem = new ZhOrderitem();
            Double subtotal = 0.0;
            subtotal = orderPojo.getCount() * orderPojo.getMarketPrice();
            orderitem.setColor(orderPojo.getColor());
            orderitem.setCount(orderPojo.getCount());
            orderitem.setOid(order.getOid());
            orderitem.setPid(orderPojo.getPid());
            orderitem.setSize(orderPojo.getSize());
            orderitem.setSubtotal(subtotal);
            int insert1 = orderitemMapper.insert(orderitem);
        }
        //调用支付
        try {
          String result = toPay(order.getOid(),order.getTotal());
          return  result;
        }catch (Exception e){
            throw new MyException(ZhahuoExceptionEnum.PAY_ERROR);
        }
    }

    public String toPay(Integer orderId,Double total) throws Exception{
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        try {
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ orderId +"\","
                    + "\"total_amount\":\""+ total +"\","
                    + "\"subject\":\""+ "测试支付" +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

            //请求
            String result;
            result = alipayClient.pageExecute(alipayRequest).getBody();
            System.out.println("*********************\n返回结果为："+result);
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
