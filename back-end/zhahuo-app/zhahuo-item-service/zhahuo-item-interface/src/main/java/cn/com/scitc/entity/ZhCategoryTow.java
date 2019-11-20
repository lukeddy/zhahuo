package cn.com.scitc.entity;

import javax.persistence.*;

@Table(name = "zh_category_tow")
public class ZhCategoryTow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid;

    @Column(name = "bname")
    private String bname;

    @Column(name = "cid")
    private Integer cid;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "ZhCategoryTow{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", cid=" + cid +
                '}';
    }
}
