package com.zhiqin.module.utils;

/**
 * 
 * @author ws
 *
 */
public class RespBaseUtils {
	public static <T> RespBase<T> setResult(T result) {
		RespBase<T> rs = new RespBase<T>();
		rs.setResult(result);
		return rs;
	}

	public static <T> RespBase<T> setErrorResult(String errorMsg) {
		RespBase<T> rs = new RespBase<T>();
		rs.setErrorCode(-1);
		rs.setErrorMsg(errorMsg);
		return rs;
	}
}
