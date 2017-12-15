package com.zhiqin.module.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by maple on 2017/12/6.
 */
@Entity
@Table(name = "comment_user")
public class CommentUserVoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer userId;
    private String userName = "";
    private String content = "";
    private Integer msgId;
    private Date createTime;
    private String createTimeStr = "";

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
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
