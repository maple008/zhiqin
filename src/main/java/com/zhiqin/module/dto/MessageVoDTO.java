package com.zhiqin.module.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by maple on 2017/12/6.
 */
@Entity
@Table(name = "message_info")
public class MessageVoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer userId;
    private String userName="";
    private String content="";
    private String photo="";
    private Date createTime;
    private String createTimeStr="";
    private List<CommentUserVoDTO> commentUserVoDTOS = new ArrayList<>();
    //页码
    private int pageIndex;
    //每页数量
    private int pageSize;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public List<CommentUserVoDTO> getCommentUserVoDTOS() {
        return commentUserVoDTOS;
    }

    public void setCommentUserVoDTOS(List<CommentUserVoDTO> commentUserVoDTOS) {
        this.commentUserVoDTOS = commentUserVoDTOS;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
