package cn.com.scitc.pojo;

public class ProductPojo {
    private String pname;
    private String cname;
    private String bname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "ProductPojo{" +
                "pname='" + pname + '\'' +
                ", cname='" + cname + '\'' +
                ", bname='" + bname + '\'' +
                '}';
    }
}
