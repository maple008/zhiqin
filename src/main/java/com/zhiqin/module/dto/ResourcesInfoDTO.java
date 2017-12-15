package com.zhiqin.module.dto;

import com.zhiqin.module.sql.entity.CommentVo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by maple on 2017/12/6.
 */
public class ResourcesInfoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String title="";
    private String content="";
    private String coverImage="";
    private String duration="";
    private String resourcesFile="";
    private String resourcesFileName="";
    private Integer state;
    private Integer weight;
    private Date createDatetime;
    private Date updateDatetime;
    private String score="";
    private Integer clicks;
    private Integer weighing;
    private List<CommentVoDTO> listCommentVoDTO=new ArrayList<>();;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getResourcesFile() {
        return resourcesFile;
    }

    public void setResourcesFile(String resourcesFile) {
        this.resourcesFile = resourcesFile;
    }

    public String getResourcesFileName() {
        return resourcesFileName;
    }

    public void setResourcesFileName(String resourcesFileName) {
        this.resourcesFileName = resourcesFileName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Integer getWeighing() {
        return weighing;
    }

    public void setWeighing(Integer weighing) {
        this.weighing = weighing;
    }

    public List<CommentVoDTO> getListCommentVoDTO() {
        return listCommentVoDTO;
    }

    public void setListCommentVoDTO(List<CommentVoDTO> listCommentVoDTO) {
        this.listCommentVoDTO = listCommentVoDTO;
    }
}
