package cn.com.scitc.pojo;

public class CatePojo {
    private Integer pid;
    private Integer cid;
    private Integer bid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "CatePojo{" +
                "pid=" + pid +
                ", cid=" + cid +
                ", bid=" + bid +
                '}';
    }
}
