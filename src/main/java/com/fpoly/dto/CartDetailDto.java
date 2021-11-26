package com.fpoly.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CartDetailDto implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Long orderId;
	private Long productId;
	private String name;
	private String slug;
	private Double price;
	private Integer quantity;
	private String imgUrl;

}
