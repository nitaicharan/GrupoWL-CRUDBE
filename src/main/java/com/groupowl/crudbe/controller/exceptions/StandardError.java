package com.groupowl.crudbe.controller.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class StandardError {
    
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

}