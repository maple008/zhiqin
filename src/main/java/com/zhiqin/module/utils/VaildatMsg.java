package com.zhiqin.module.utils;
public class VaildatMsg {

	public int errorCode = -1;
	public String errorMsg = null;
	
	public VaildatMsg(int errorCode){
		this.errorCode = errorCode;
		
	}
	
	public VaildatMsg(int errorCode,String errorMsg){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
}