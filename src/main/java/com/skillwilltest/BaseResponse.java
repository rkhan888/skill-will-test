package com.skillwilltest;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class BaseResponse {

	private boolean isError;
	private String responseCode;
	private String responseMsg;
	private LocalDateTime timestamp;
	
	public BaseResponse() {
	}

}
