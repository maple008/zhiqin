package com.zhiqin.module.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by maple on 2017/12/6.
 */
public class TagResourcesDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer tagId;
    private Integer parentId;
    private Integer resourcesId;
    private String tagParentId="";
    private String resourcesTitle="";
    private String resourcesDuration="";
    private String resourcesCoverImage="";
    private String codeName="";
    private String resourcesFile="";
    private String score="";
    private Integer clicks;
    private Integer weight;
    //页码
    private int pageIndex=1;
    //每页数量
    private int pageSize=10;

    private int codeId;//分类ID

    @Override
    public String toString() {
        return "TagResourcesDTO{" +
                "id=" + id +
                ", tagId=" + tagId +
                ", parentId=" + parentId +
                ", resourcesId=" + resourcesId +
                ", tagParentId='" + tagParentId + '\'' +
                ", resourcesTitle='" + resourcesTitle + '\'' +
                ", resourcesDuration='" + resourcesDuration + '\'' +
                ", resourcesCoverImage='" + resourcesCoverImage + '\'' +
                ", codeName='" + codeName + '\'' +
                ", resourcesFile='" + resourcesFile + '\'' +
                ", score='" + score + '\'' +
                ", clicks=" + clicks +
                ", weight=" + weight +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", codeId=" + codeId +
                '}';
    }

    public int getCodeId() {
        return codeId;
    }

    public void setCodeId(int codeId) {
        this.codeId = codeId;
    }

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
