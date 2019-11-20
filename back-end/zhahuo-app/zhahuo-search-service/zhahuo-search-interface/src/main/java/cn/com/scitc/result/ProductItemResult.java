package cn.com.scitc.result;


import cn.com.scitc.entity.ZhImage;
import cn.com.scitc.entity.ZhProduct;

public class ProductItemResult {
    private ZhProduct product;
    private ZhImage image;

    public ZhProduct getProduct() {
        return product;
    }

    public void setProduct(ZhProduct product) {
        this.product = product;
    }

    public ZhImage getImage() {
        return image;
    }

    public void setImage(ZhImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductItemResult{" +
                "product=" + product +
                ", image=" + image +
                '}';
    }
}
