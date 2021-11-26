package com.fpoly.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.service.CartService;
import com.fpoly.dto.CartDto;

@RestController
@RequestMapping("/api/cart")
public class CartApi {
	@Autowired
	private CartService cartService;
	
	
	@GetMapping("/update")
	public ResponseEntity<?> doUpdate(@RequestParam("productId") Long productId,
			@RequestParam("quantity") Integer quantity,
			@RequestParam("isReplace") Boolean isReplace,
			HttpSession session) {
		CartDto currentCart = (CartDto) session.getAttribute("currentCart");
		cartService.updateCart(currentCart, productId, quantity, isReplace);
		session.setAttribute("currentCart","currentCart");
		
		return ResponseEntity.ok(currentCart);
	}

}
