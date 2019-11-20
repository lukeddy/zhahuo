package cn.com.scitc.pojo;

import lombok.Data;

public class PageResultPojo {
    //当前页
    private Integer page;
    //每页数据量
    private Integer rows;
    //排序条件
    private String sortBy;
    //排序方式
    private Boolean desc;
    //分页条件
    private String key;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Boolean getDesc() {
        return desc;
    }

    public void setDesc(Boolean desc) {
        this.desc = desc;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "PageResultPojo{" +
                "page=" + page +
                ", rows=" + rows +
                ", sortBy='" + sortBy + '\'' +
                ", desc=" + desc +
                ", key='" + key + '\'' +
                '}';
    }
}
