package com.fpoly.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.entity.Products;
import com.fpoly.service.ProductsService;

@RestController
@RequestMapping("/api/product")
public class ProductsApi {
	@Autowired ProductsService service;
	
	@GetMapping("/")
	public ResponseEntity<?> doGetAll(){
		List<Products> result =service.findAll();
		return ResponseEntity.ok(result);
	}
}
