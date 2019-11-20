package cn.com.scitc.pojo;

public class Phone {
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PhonePojo{" +
                "phone='" + phone + '\'' +
                '}';
    }
}
