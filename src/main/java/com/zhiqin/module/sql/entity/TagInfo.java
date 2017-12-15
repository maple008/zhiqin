package com.zhiqin.module.sql.entity;

import javax.persistence.*;

/**
 * Created by maple on 2017/11/24.
 */
@Entity
@Table(name = "tag")
public class TagInfo {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "PARENT_ID")
    private Integer parentId;
    @Column(name = "CODE_ID")
    private Integer codeId;
    @Column(name = "tag_parent_id")
    private String tagParentId;
    @Column(name = "name")
    private String name;


    @Override
    public String toString() {
        return "TagInfo{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", codeId=" + codeId +
                ", tagParentId='" + tagParentId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getCodeId() {
        return codeId;
    }

    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }

    public String getTagParentId() {
        return tagParentId;
    }

    public void setTagParentId(String tagParentId) {
        this.tagParentId = tagParentId;
    }
}
