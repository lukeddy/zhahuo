package cn.com.scitc.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "zh_order")
public class ZhOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;
    @Column(name = "ordertime")
    private Date ordertime;

    @Column(name = "total")
    private Double total;

    @Column(name = "state")
    private Integer state;

    @Column(name = "address")
    private String address;

    @Column(name = "name")
    private String name;

    @Column(name = "telephone")
    private String telephone;
    @Column(name = "uid")
    private Integer uid;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "ZhOrder{" +
                "oid=" + oid +
                ", ordertime=" + ordertime +
                ", total=" + total +
                ", state=" + state +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", uid=" + uid +
                '}';
    }
}
