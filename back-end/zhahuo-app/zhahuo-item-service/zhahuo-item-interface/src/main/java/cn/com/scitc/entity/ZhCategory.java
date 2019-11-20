package cn.com.scitc.entity;

import javax.persistence.*;

@Table(name = "zh_category")
public class ZhCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @Column(name = "cname")
    private String cname;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "ZhCategory{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }
}
