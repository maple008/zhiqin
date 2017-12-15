package com.zhiqin.module.utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class RespBase<T> {
	//private Gson gson = new Gson();
	private ObjectMapper mapper = new ObjectMapper();

   // ArrayList<RespUserExperience> l = mapper.convertValue(respBase.getResult(),  new TypeReference<List<RespUserExperience>>(){});
    /**
     * 错误描述code
     */
    private int errorCode = 0;
    /**
     * 错误描述信息，errorCode 不为0时，errorMsg 不能为空
     */
    private String errorMsg="";
    //返回结果
    private T result;


    public Object result(TypeReference<?> toValueTypeRef) {
    	return mapper.convertValue(this.result,  toValueTypeRef);
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
