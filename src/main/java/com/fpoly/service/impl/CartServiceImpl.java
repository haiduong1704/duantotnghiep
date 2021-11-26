package com.fpoly.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.dto.CartDetailDto;
import com.fpoly.dto.CartDto;
import com.fpoly.entity.Products;
import com.fpoly.service.CartService;
import com.fpoly.service.ProductsService;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private ProductsService productService;
//
	//@Autowired
	//private OrdersService orderService;

	//@Autowired
	//private OrderDetailsService orderDetailService;


	public CartDto updateCart(CartDto cart, long productId, int quantity, boolean isReplace) {
		Products product = productService.findById(productId);
		HashMap<Long, CartDetailDto> listDetail = cart.getListDetail();

		if (!listDetail.containsKey(productId)) {
			CartDetailDto cartDetail = new CartDetailDto();
			cartDetail.setProductId(product.getId());
			cartDetail.setImgUrl(product.getImgUrl());
			cartDetail.setName(product.getName());
			cartDetail.setPrice(product.getPrice());
			cartDetail.setQuantity(quantity);
			cartDetail.setSlug(product.getSlug());
			listDetail.put(productId, cartDetail);
		} else if (quantity > 0) {
			if (isReplace) {
				listDetail.get(productId).setQuantity(quantity);
			} else {
				Integer oldQuantity = listDetail.get(productId).getQuantity();
				listDetail.get(productId).setQuantity(oldQuantity + quantity);
			}
		} else {
			listDetail.remove(productId);
		}
		cart.setTotalPrice(this.getTotalPrice(cart));
		cart.setTotalQuantity(this.getTotalQuantity(cart));
		return cart;
	}


@Override
public Integer getTotalQuantity(CartDto cart) {
	HashMap<Long, CartDetailDto> cartDetail = cart.getListDetail();
	Integer totalQuantity = 0;
	for (CartDetailDto cartDetailDto : cartDetail.values()) {
		totalQuantity += cartDetailDto.getQuantity();
	}
	return totalQuantity;
}
@Override
public Double getTotalPrice(CartDto cart) {
	HashMap<Long, CartDetailDto> cartDetail = cart.getListDetail();
	Double totalPrice = 0D;
	for (CartDetailDto cartDetailDto : cartDetail.values()) {
		Products product = productService.findById(cartDetailDto.getProductId());
		totalPrice += product.getPrice() * cartDetailDto.getQuantity();
	}
	return totalPrice;
}

}
