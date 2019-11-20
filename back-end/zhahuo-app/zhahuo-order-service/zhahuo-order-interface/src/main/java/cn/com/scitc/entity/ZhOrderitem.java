package cn.com.scitc.entity;

import javax.persistence.*;

@Table(name = "zh_orderitem")
public class ZhOrderitem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemid;
    @Column(name = "count")
    private  Integer count;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "pid")
    private Integer pid;

    @Column(name = "oid")
    private Integer oid;

    @Column(name = "size")
    private String size;

    @Column(name = "color")
    private String color;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ZhOrderitem{" +
                "itemid=" + itemid +
                ", count=" + count +
                ", subtotal=" + subtotal +
                ", pid=" + pid +
                ", oid=" + oid +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
