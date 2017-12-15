package com.zhiqin.module.utils;

import org.hibernate.HibernateException;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maple on 2017/7/7.
 */
public class PageQuery {
    private List result; // 结果集
    private int pageSize; // 页大小
    private int startPage; // 起始页 从1开始
    private int totalResults; // 总记录的条数
    private int totalPages; // 总页数


    public PageQuery(int startPage, int pageSize, Query query) {
        this.startPage = startPage;
        //档pageindex活pageSize小于等于0时，附上默认值。
        if (startPage <= 0) {
            startPage = 1;
        }
        this.pageSize = pageSize;
        if (pageSize <= 0) {
            pageSize = 8;
        }
        this.result = new ArrayList();
        try {
            this.totalResults = query.getResultList().size();
            setTotalPages();
            result = query.setFirstResult(
                    (this.getStartPage() - 1) * this.pageSize < 0 ? 0 : (this.getStartPage() - 1) * this.pageSize).setMaxResults(
                    this.pageSize).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到查询结果
     *
     * @return 查询结果
     */
    public List getResult() {
        return result;
    }

    //注入结果
    public void setResult(List result) {
        this.result = result;
    }

    /**
     * 得到起始页
     *
     * @return
     */
    public int getStartPage() {
        if (startPage < 1) {
            startPage = 1;
        }
        if (startPage > totalPages) {
            startPage = totalPages;
        }
        return startPage;
    }

    /**
     * 得到记录总数
     *
     * @return
     */
    public int getTotalResults() {
        return totalResults;
    }

    /**
     * 得到页大小
     *
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 判断是否是第一页
     *
     * @return
     */
    public boolean isFirstPage() {
        return this.startPage == 1;
    }

    /**
     * 判断是否是有后一页
     *
     * @return
     */
    public boolean hasNextPage() {
        return this.startPage < this.totalPages;
    }

    /**
     * 判断是否是有前一页
     *
     * @return
     */
    public boolean hasPreviousPage() {
        return this.startPage > 1;
    }

    /**
     * 设置总页数
     */
    private void setTotalPages() {
        this.totalPages = this.totalResults / this.pageSize;
        if (totalPages * pageSize < totalResults) {
            totalPages++;
        }
    }

    /**
     * 得到总页数
     *
     * @return
     */
    public int getTotalPages() {
        return totalPages;
    }
}
