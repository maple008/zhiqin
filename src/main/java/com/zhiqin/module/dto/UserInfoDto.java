package com.zhiqin.module.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by maple on 2017/11/24.
 */
public class UserInfoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nickName="";
    @NotBlank(message = "valid.login.pwd")
    private String pwd="";
    @NotBlank(message = "register.phone.empty")
    private String mobile="";
    private String email="";
    private String state="";
    private Date createTime;//注册时间
    private Date updateTime;

    @Override
    public String toString() {
        return "UserInfoDto{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
