package com.zhiqin.module.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

/**
 * Created by maple on 2017/12/8.
 */
public class Test {
    public static void main(String[] args) {
        String aa = "{\n" +
                "    \"errorCode\": 0,\n" +
                "    \"errorMsg\": \"\",\n" +
                "    \"result\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"title\": \"安全教育111\",\n" +
                "            \"content\": \"安全教育111111111\",\n" +
                "            \"coverImage\": \"http://zhiqinimages.oss-cn-beijing.aliyuncs.com/a9d81812-6fd4-454d-bfac-85c126a3f361.jpg\",\n" +
                "            \"duration\": \"10\",\n" +
                "            \"resourcesFile\": \"http://zhiqin-files.oss-cn-beijing.aliyuncs.com/pdf/\",\n" +
                "            \"resourcesFileName\": \"pdf\",\n" +
                "            \"state\": 2,\n" +
                "            \"weight\": 1,\n" +
                "            \"score\": \"\",\n" +
                "            \"clicks\": 116,\n" +
                "            \"type\": 1,\n" +
                "            \"codeName\": \"\",\n" +
                "            \"tagId\": \"\",\n" +
                "            \"createDatetime\": null,\n" +
                "            \"weighing\": 2,\n" +
                "            \"listCommentVoDTO\": [\n" +
                "                {\n" +
                "                    \"id\": 1,\n" +
                "                    \"userId\": 2,\n" +
                "                    \"resourceId\": 1,\n" +
                "                    \"content\": \"评论评论\",\n" +
                "                    \"createTime\": null\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 2,\n" +
                "                    \"userId\": 1,\n" +
                "                    \"resourceId\": 1,\n" +
                "                    \"content\": \"评论22222评论333\",\n" +
                "                    \"createTime\": 1512629755000\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 3,\n" +
                "                    \"userId\": 1,\n" +
                "                    \"resourceId\": 1,\n" +
                "                    \"content\": \"评论22222评论333\",\n" +
                "                    \"createTime\": 1512629932000\n" +
                "                }\n" +
                "            ],\n" +
                "            \"pageIndex\": 0,\n" +
                "            \"pageSize\": 0\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        System.out.println(aa);
        JSONObject jsonObject = JSONObject.parseObject(aa);
        JSONArray jsonArray = jsonObject.getJSONArray("result");
        for (int i = 0; i < jsonArray.size(); i++) {
            System.out.println(jsonArray.get(i));
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            System.out.println(jsonObject1.get("content").toString());
        }

    }

}
