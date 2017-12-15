package com.zhiqin.module.sql.entity;

import javax.persistence.*;

/**
 * Created by maple on 2017/11/24.
 */
@Entity
@Table(name = "tag_code")
public class TagCode {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return "TagCode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
