package com.fpoly.service;

import java.sql.SQLException;


import com.fpoly.dto.CartDto;

public interface CartService {
	
	 CartDto updateCart(CartDto cart, long productId, int quantity, boolean isReplace) ;
		
	Integer getTotalQuantity(CartDto cart);
	Double getTotalPrice(CartDto cart);
	
	
	
}
