package com.github.surpassm.aliapi.common.enums;

import lombok.Getter;

/**
 * @author mc
 * @version 1.0
 * @date 2018/12/19 15:24
 * @description
 */
@Getter
public enum ExcaptionEnums {
	/**
	 * 参数不能为空
	 */
	PARAMETERS_NOTNULL(400,"参数不能为空"),
	/**
	 * 参数非法
	 */
	ILLEGAL_PARAMETERS(400,"参数非法"),
	/**
	 * 类型错误
	 */
	TYPE_ERROR(400,"参数类型错误"),


	;
	private Integer key;
	private String value;

	ExcaptionEnums(Integer key, String value){
		this.key=key;
		this.value=value;
	}
}
