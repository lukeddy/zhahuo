package cn.com.scitc.pojo;

public class SearchPojo {
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "SearchPojo{" +
                "keyword='" + keyword + '\'' +
                '}';
    }
}
