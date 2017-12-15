package com.zhiqin.module.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by maple on 2017/11/24.
 */
public class DictionaryDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer parentId;
    private Integer codeId;
    private String tagParentId="";
    private String name="";
    private List<DictionaryDto> dictionaryDtos=new ArrayList<>();


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DictionaryDto> getDictionaryDtos() {
        return dictionaryDtos;
    }

    public void setDictionaryDtos(List<DictionaryDto> dictionaryDtos) {
        this.dictionaryDtos = dictionaryDtos;
    }
}

