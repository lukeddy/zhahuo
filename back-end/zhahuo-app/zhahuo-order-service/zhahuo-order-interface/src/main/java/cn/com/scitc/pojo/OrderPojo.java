package cn.com.scitc.pojo;

public class OrderPojo {
    private Integer cartId;
    private Integer uid;
    private Integer pid;
    private String color;
    private Integer count;
    private Double marketPrice;
    private String pimage;
    private String pname;
    private String size;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "OrderPojo{" +
                "cartId=" + cartId +
                ", uid=" + uid +
                ", pid=" + pid +
                ", color='" + color + '\'' +
                ", count=" + count +
                ", marketPrice=" + marketPrice +
                ", pimage='" + pimage + '\'' +
                ", pname='" + pname + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
