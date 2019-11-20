package cn.com.scitc.result;

import cn.com.scitc.entity.ZhCategoryTow;

import javax.persistence.*;
import java.util.List;

public class ItemResult {
    private int cid;
    private String cname;
    @Transient
    private List<ZhCategoryTow> zhCategoryTow;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<ZhCategoryTow> getZhCategoryTow() {
        return zhCategoryTow;
    }

    public void setZhCategoryTow(List<ZhCategoryTow> zhCategoryTow) {
        this.zhCategoryTow = zhCategoryTow;
    }

    @Override
    public String toString() {
        return "ItemResult{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", zhCategoryTow=" + zhCategoryTow +
                '}';
    }
}
