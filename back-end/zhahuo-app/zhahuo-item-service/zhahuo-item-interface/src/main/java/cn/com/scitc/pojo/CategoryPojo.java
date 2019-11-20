package cn.com.scitc.pojo;


public class CategoryPojo {
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

    @Override
    public String toString() {
        return "CategoryPojo{" +
                "cname='" + cname + '\'' +
                ", bname='" + bname + '\'' +
                '}';
    }
}
