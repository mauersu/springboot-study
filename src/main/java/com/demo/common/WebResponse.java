package com.demo.common;

import lombok.Data;

@Data
public class WebResponse<T> {
	
	private String code;
	private String msg;
	private T data;
	
	public WebResponse(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static WebResponse success() {
		WebResponse res = new WebResponse(ErrorCodeEnum.SUCCESS.getCode(), ErrorCodeEnum.SUCCESS.getMsg(), null);
		return res;
	}
	
	
	public static <T> WebResponse success(T data) {
		WebResponse res = new WebResponse(ErrorCodeEnum.SUCCESS.getCode(), ErrorCodeEnum.SUCCESS.getMsg(), data);
		return res;
	}
	
	public static WebResponse failed(ErrorCodeEnum errorEnum) {
		WebResponse res = new WebResponse(errorEnum.getCode(), errorEnum.getMsg(), null);
		return res;
	}
	
	public static WebResponse failed(ErrorCodeEnum errorEnum, String msg) {
		WebResponse res = new WebResponse(errorEnum.getCode(), msg, null);
		return res;
	}
	
	public static WebResponse failed(String code, String msg) {
		WebResponse res = new WebResponse(code, msg, null);
		return res;
	}

}
