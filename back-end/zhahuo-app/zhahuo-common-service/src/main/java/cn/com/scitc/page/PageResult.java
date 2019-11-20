package cn.com.scitc.page;

import java.util.List;

/**
 * 通用分页接收对象
 * @param <T>
 */
public class PageResult<T> {
    private Long total; //总条数
    private Integer totalPage;//总页数
    private Integer currentPageNum;//当前页
    private List<T> currentPage;//返回的当前数据

    public PageResult(Long total, Integer totalPage, Integer currentPageNum, List<T> currentPage) {
        this.total = total;
        this.totalPage = totalPage;
        this.currentPageNum = currentPageNum;
        this.currentPage = currentPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(Integer currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public List<T> getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(List<T> currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "total=" + total +
                ", totalPage=" + totalPage +
                ", currentPageNum=" + currentPageNum +
                ", currentPage=" + currentPage +
                '}';
    }
}
