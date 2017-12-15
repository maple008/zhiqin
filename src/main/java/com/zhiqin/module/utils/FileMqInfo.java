package com.zhiqin.module.utils;

import java.io.Serializable;

/**
 * Created by maple on 2017/8/29.
 */
public class FileMqInfo implements Serializable {
    private String result;//传的值需要生成的值
    private Integer type;//传输的类型:0为JS文件
    private String url;//传输的文件储存地址

    @Override
    public String toString() {
        return "fileMqInfo{" +
                "result='" + result + '\'' +
                ", type=" + type +
                ", url='" + url + '\'' +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
