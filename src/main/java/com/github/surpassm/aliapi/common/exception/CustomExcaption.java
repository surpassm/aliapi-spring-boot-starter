package com.github.surpassm.aliapi.common.exception;


import java.io.Serializable;

/**
 * @author mc
 * @version 1.0
 * @date 2018/12/19 14:50
 * @description 自定义异常处理器
 */
public class CustomExcaption extends RuntimeException implements Serializable {

	public CustomExcaption (String message){
		super(message);
	}
}
