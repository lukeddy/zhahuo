package cn.com.scitc.entity;


import javax.persistence.*;

@Table(name = "zh_cart")
public class ZhCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @Column(name = "cart_product_name")
    private String cartProductName;
    @Column(name = "cart_product_color")
    private String cartProductColor;
    @Column(name = "cart_product_image")
    private String cartProductImage;
    @Column(name = "cart_product_size")
    private String cartProductSize;
    @Column(name = "cart_product_mp")
    private Double cartProductMp;
    @Column(name = "cart_product_count")
    private Integer cartProductCount;

    @Column(name = "pid")
    private Integer pid;
    @Column(name = "uid")
    private Integer uid;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getCartProductName() {
        return cartProductName;
    }

    public void setCartProductName(String cartProductName) {
        this.cartProductName = cartProductName;
    }

    public String getCartProductColor() {
        return cartProductColor;
    }

    public void setCartProductColor(String cartProductColor) {
        this.cartProductColor = cartProductColor;
    }

    public String getCartProductSize() {
        return cartProductSize;
    }

    public void setCartProductSize(String cartProductSize) {
        this.cartProductSize = cartProductSize;
    }

    public Double getCartProductMp() {
        return cartProductMp;
    }

    public void setCartProductMp(Double cartProductMp) {
        this.cartProductMp = cartProductMp;
    }

    public Integer getCartProductCount() {
        return cartProductCount;
    }

    public void setCartProductCount(Integer cartProductCount) {
        this.cartProductCount = cartProductCount;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getCartProductImage() {
        return cartProductImage;
    }

    public void setCartProductImage(String cartProductImage) {
        this.cartProductImage = cartProductImage;
    }

    @Override
    public String toString() {
        return "ZhCart{" +
                "cartId=" + cartId +
                ", cartProductName='" + cartProductName + '\'' +
                ", cartProductColor='" + cartProductColor + '\'' +
                ", cartProductImage='" + cartProductImage + '\'' +
                ", cartProductSize='" + cartProductSize + '\'' +
                ", cartProductMp=" + cartProductMp +
                ", cartProductCount=" + cartProductCount +
                ", pid=" + pid +
                ", uid=" + uid +
                '}';
    }
}
