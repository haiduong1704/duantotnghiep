package com.fpoly.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private String address;
	private String phone;
	private Timestamp createdDate;
	private HashMap<Long, CartDetailDto> listDetail = new HashMap<>();
	private Integer totalQuantity = 0;
	private Double totalPrice = 0D;
}
