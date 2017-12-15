package com.zhiqin.module.sql.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by maple on 2017/12/6.
 */
@Entity
@Table(name = "resources")
public class ResourcesInfo {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "COVER_IMAGE")
    private String coverImage;
    @Column(name = "DURATION")
    private String duration;
    @Column(name = "RESOURCES_FILE")
    private String resourcesFile;
    @Column(name = "RESOURCES_FILE_NAME")
    private String resourcesFileName;
    @Column(name = "STATE")
    private Integer state;
    @Column(name = "WEIGHT")
    private Integer weight;
    @Column(name = "CREATE_DATETIME")
    private Date createDatetime;
    @Column(name = "UPDATE_DATETIME")
    private Date updateDatetime;
    @Column(name = "SCORE")
    private String score;
    @Column(name = "CLICKS")
    private Integer clicks;
    @Column(name = "WEIGHING")
    private Integer weighing;

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
}
