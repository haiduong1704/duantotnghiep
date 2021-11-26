package com.fpoly.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;

import javax.annotation.Generated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadFileResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String address;
	private String phone;
	private Timestamp createdDate;
	private HashMap<Long, CartDetailDto> listDetail = new HashMap<>();
	private Integer totalQuantity = 0;
	private Double totalPrice = 0D;
	
}
