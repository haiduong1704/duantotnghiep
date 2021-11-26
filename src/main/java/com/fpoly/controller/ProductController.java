package com.fpoly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.entity.Products;
import com.fpoly.entity.ProductTypes;
import com.fpoly.service.ProductsService;
import com.fpoly.service.ProductTypesService;

@Controller
@RequestMapping("/sanpham")
public class ProductController {
	
	@Autowired
	private ProductsService productService;
	
//	@Autowired
//	private ProductTypesService productTypesService;
//	
//	// localhost:8080/sanpham/detail/iphone-11-64gb
//	@GetMapping("/detail/{slug}")
//	public String doGetProductBySlug(Model model,
//			@PathVariable("slug") String slug) {
//		Products products = productService.findBySlug(slug);
//		model.addAttribute("products", products);
//		return "home/detail";
//	}

	// localhost:8080/sanpham/dien-thoai
//	@GetMapping("/{typeSlug}")
//	public String doGetProductsByType(Model model, 
//			@PathVariable("typeSlug") String typeSlug) {
//		ProductTypes type = typeOfProductService.findBySlug(typeSlug);
//		
//		if (ObjectUtils.isEmpty(type)) {
//			model.addAttribute("errorMsg", "Product type does not exist!!!");
//			return "home/error";
//		}
//		
//		model.addAttribute("currentType", type);
//
//		List<Products> listProductByType = productService.findById(type.getId());
//		model.addAttribute("listProductByType", listProductByType);
//		return "home/typeofproduct";
//	}

}

