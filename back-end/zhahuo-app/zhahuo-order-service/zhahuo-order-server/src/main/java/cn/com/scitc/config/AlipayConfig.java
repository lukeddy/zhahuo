package cn.com.scitc.config;

public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101700705282";
    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCK8F/h4fbp3WISeVWXWqTGQloutndnj12hlx4xlF8W4DquVhGz84moD60THf8IsMx9J+BZTEynK1P/jQCulfBPwvX39RxueVDEjfRYpvumLEDmfg33QPWMzFTUsaFOMvtoxJ8qM37d4LD+tftKnjmqBAH/Zf257cbKT4gQWMkfjd+q9KX/fHHilEnWhzv5opgIz+ZlDhfPH8fHS4cj47M2Lk2hMHJVPrPoz1OQPMKMiN7xnCZCz1n2CTIO6hrtxa2lcXJ/+nXJFsXo5CWmmPk9FEKsxEwYQvR1iXBnq7fx1cWyiEgynFfFzLnpjZgxlrx0pFVomLJY7RyRWhVyoXYVAgMBAAECggEAHMQyBfGkDr2wbYTDrOeukAHy7BMJW966ExfXv4opufHJFIlrdueoi6xbOEcQo7r/S7Zy4+pBQKde591I09zleY4zIRiVv2XMzDVb7vL7zWcCNPbKa3P+ox03PyZb8HXrycBT+Afbb5Ly8nm5QrTJ2aKkyz1RsCpD62VWFZRcZ/TGDv3KAJr3sLxzvxyI3cRvjhYqNnenh9DA3K/vQ/7i0HxXxT1UxPIX7oH4f0I5oKsAIiSjvTzSE7QwtuEfnEe9ojBkN2dKlmU6XQnbHptcqkNjjlcz/uxpcZ7nG+KIQdSrqsFR/O/8z7rM9Yb70JRuZwwKkacYFo/k0J4ZY8F0rQKBgQD1uBOhy6++iUOH2dQysFV6FFnWI1zAVm5bNTaaiGYTRfTXqVK1+1/o5wj4Zodvp5ksIv7B/RsyD6UDKfeIrWALYV67tDzpuyL6VyvNjCZy75hbaj7jZQANP3DtoiduXZTADmeppUDdrdmcyDTQDZd2FI1A8VkPr4zXJbLuHZQtywKBgQCQwJCWp+LOfAvKngpoWV6s+OZtS1+v9ytAW6fWvg0lZKptxOfd7aK0lQesBUNtvk3/RTulejLgXfZfP3jkS2O63oOajniguCHHCUXvPAB4pn7LGOMhryjcRKKjSFgUmFSdbue5BF4t+PC+ExDf/wOdUnqghJMf7EvGZr/P43pvnwKBgQD0gg2XDJZ+5Rv7zPho0CreZe3XNi0Pf3Ik9Fi3gU8BkrVG/Mi/KbqQiYXVmEDhDEdRMimLY49ySzsKYPJeYReXe3bHFV0fwAXYUnHWAcYozN4w6RJXOKPKivyWmqreGeTxD+R7XWOks2A9sMNM3JmA+IZuvzq+bxOY63yXkXtn7QKBgQCMXQ5X6Mh4LbVJbuLsuOyjkl/vT42kFmusZrRj+brJrcnN04h7nXmO3oyn9Bqkiksb48io98vp4XOMfQH/blNw22CGOO0j/ClU1dso1ugmFl0RGDr3aOCYZz3GU9qFbglu+CJfOKsSrTjVN6u/aYvZvCcJDEWWSQ5Zfz00m4MYRQKBgQCWL6XlHqZBzZ6uGek7WgpZuisO2qmXIccM0tChhRVXIE8nu51EYhhz8WtDQtshDm+t8MD+SqxWISqpabOI+6eR0inM09a2XU9flA3EyLv7euwbRWrcXa/ht/08Pw5RmeCeTZWeutQfJyRUNF5/vZ3qimmXsGELEbRe4bepZsvdcQ==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA4Y2WtjvuvsA1BesCk9f8uDmwcYKA8ApfgrRmmwZ1chg6k2PG/7DAaVkMPOjR4Z4fUe8JdFRJyPO10u6BiPpmhiQDA0TjMIqbM4LYW+itg1l7giU1oNhW6MtxdI1bA8DJeQtOZsQJKBRz3UGYmTXEBJgjRJLO0ziCi/1WHcG2kEJ+qwaJ54P0iSpNjj/rNm54yk3SZjIyH8P7JR4OanJe4X63HKj3+OAoXHd8gMR57NeWxbt6gCPDRJW5dC5Yp2OtUF8IFOECFeRMIypMYk3Y0aHKBYStRA7Lc2eWdPTs/ZL9loVZ39N6LCwx9EbArpnIdUabKnJr21SnYOJV9n5zHwIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:10010/api/order/back";
    // 页面跳转同步通知页面路径
//    public static String return_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
    public static String return_url = "http://localhost:3000";
    // 签名方式，注意这里，如果步骤设置的是RSA则用RSA
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关https://openapi.alipaydev.com/gateway.do
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 支付宝网关日志路径
//    public static String log_path = "C:\\";
}
