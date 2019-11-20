package cn.com.scitc.entity;

import javax.persistence.*;

@Table(name = "zh_image")
public class ZhImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageid;

    @Column(name = "image_addr")
    private String imageAddr;

    @Column(name = "image_color")
    private String imageColor;

    @Column(name = "image_size")
    private String imageSize;

    @Column(name = "pid")
    private String pid;

    public Integer getImageid() {
        return imageid;
    }

    public void setImageid(Integer imageid) {
        this.imageid = imageid;
    }

    public String getImageAddr() {
        return imageAddr;
    }

    public void setImageAddr(String imageAddr) {
        this.imageAddr = imageAddr;
    }

    public String getImageColor() {
        return imageColor;
    }

    public void setImageColor(String imageColor) {
        this.imageColor = imageColor;
    }

    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "ZhImage{" +
                "imageid=" + imageid +
                ", imageAddr='" + imageAddr + '\'' +
                ", imageColor='" + imageColor + '\'' +
                ", imageSize='" + imageSize + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }
}
