package com.zhiqin.module.sql.entity;

import javax.persistence.*;

/**
 * Created by maple on 2017/12/6.
 */
@Entity
@Table(name = "tag_resources")
public class TagResources {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "TAG_ID")
    private Integer tagId;
    @Column(name = "PARENT_ID")
    private Integer parentId;
    @Column(name = "RESOURCES_ID")
    private Integer resourcesId;
    @Column(name = "TAG_PARENT_ID")
    private String tagParentId;
    @Column(name = "RESOURCES_TITLE")
    private String resourcesTitle;
    @Column(name = "RESOURCES_DURATION")
    private String resourcesDuration;
    @Column(name = "RESOURCES_COVER_IMAGE")
    private String resourcesCoverImage;
    @Column(name = "CODE_NAME")
    private String codeName;
    @Column(name = "RESOURCES_FILE")
    private String resourcesFile;
    @Column(name = "SCORE")
    private String score;
    @Column(name = "CLICKS")
    private Integer clicks;
    @Column(name = "WEIGHT")
    private Integer weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Integer resourcesId) {
        this.resourcesId = resourcesId;
    }

    public String getTagParentId() {
        return tagParentId;
    }

    public void setTagParentId(String tagParentId) {
        this.tagParentId = tagParentId;
    }

    public String getResourcesTitle() {
        return resourcesTitle;
    }

    public void setResourcesTitle(String resourcesTitle) {
        this.resourcesTitle = resourcesTitle;
    }

    public String getResourcesDuration() {
        return resourcesDuration;
    }

    public void setResourcesDuration(String resourcesDuration) {
        this.resourcesDuration = resourcesDuration;
    }

    public String getResourcesCoverImage() {
        return resourcesCoverImage;
    }

    public void setResourcesCoverImage(String resourcesCoverImage) {
        this.resourcesCoverImage = resourcesCoverImage;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getResourcesFile() {
        return resourcesFile;
    }

    public void setResourcesFile(String resourcesFile) {
        this.resourcesFile = resourcesFile;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
