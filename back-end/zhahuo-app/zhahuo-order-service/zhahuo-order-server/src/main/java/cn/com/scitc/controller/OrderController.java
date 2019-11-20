package cn.com.scitc.controller;

import cn.com.scitc.config.AlipayConfig;
import cn.com.scitc.entity.ZhOrder;
import cn.com.scitc.pojo.OrderPojo;
import cn.com.scitc.service.OrderService;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.mysql.cj.x.protobuf.Mysqlx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.interfaces.PBEKey;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("toPay")
    public ResponseEntity<String> toPay(@RequestBody List<OrderPojo> orderPojoList){
        System.out.println(orderPojoList);
        String s = orderService.orderServer(orderPojoList);
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }

    @RequestMapping("toPay2")
    public String toPay2() throws Exception{
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        try {
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ 1212125 +"\","
                    + "\"total_amount\":\""+ 100 +"\","
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
    @RequestMapping("back")
    public String notifyBack(){
        System.out.println("success");
        return "success";
    }
}
