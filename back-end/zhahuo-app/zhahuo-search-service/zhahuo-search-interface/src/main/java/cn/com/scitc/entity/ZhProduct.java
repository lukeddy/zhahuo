package cn.com.scitc.entity;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import sun.util.resources.ja.CurrencyNames_ja;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "zh_product")
public class ZhProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @Column(name = "pname")
    private String pname;

    @Column(name = "market_price")
    private Double marketPrice;

    @Column(name = "shop_price")
    private Double shopPrice;

    @Column(name = "pimage")
    private String pimage;

    @Column(name = "pdate")
    private Date pdate;

    @Column(name = "is_hot")
    private Integer isHot;

    @Column(name = "pdesc")
    private String pdesc;

    @Column(name = "pflag")
    private Integer pflag;

    @Column(name = "bid")
    private Integer bid;

    @Column(name = "cid")
    private Integer cid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Double getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public Integer getPflag() {
        return pflag;
    }

    public void setPflag(Integer pflag) {
        this.pflag = pflag;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "ZhProduct{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", marketPrice=" + marketPrice +
                ", shopPrice=" + shopPrice +
                ", pimage='" + pimage + '\'' +
                ", pdate=" + pdate +
                ", isHot=" + isHot +
                ", pdesc='" + pdesc + '\'' +
                ", pflag=" + pflag +
                ", bid=" + bid +
                ", cid=" + cid +
                '}';
    }
}
