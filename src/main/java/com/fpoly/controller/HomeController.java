package com.fpoly.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fpoly.constant.SessionConst;
import com.fpoly.dto.CartDto;
import com.fpoly.entity.Products;
import com.fpoly.entity.Users;
import com.fpoly.service.ProductsService;
import com.fpoly.service.UsersSevice;

import javassist.expr.NewArray;



@Controller
public class HomeController {
	
		@Autowired 
		private ProductsService productsService;
		
		@Autowired
		private UsersSevice userService;
		
		@GetMapping({"","/index"})
		public String doGetIndex(Model model ,HttpSession session) {
		List<Products> products = productsService.findAll();
		model.addAttribute("products", products);
	
		CartDto currentCart = (CartDto)session.getAttribute("currentCart");
		if (ObjectUtils.isEmpty(currentCart)) 
		{
			session.setAttribute("currentCart",  new CartDto());
		}
			return "home/index";		
	}
		@GetMapping("/login")
		public String doGetLogin(Model model) {
			
			Users userRequest = new Users();
			model.addAttribute("userRequest", userRequest);
			return "home/login";
		}
		
		@PostMapping("/login")
		public String doPostLogin(@ModelAttribute("userRequest")Users userRequest ,Model model , HttpSession session) {
			Users userResponse = userService.doLogin(userRequest.getUsername(),userRequest.getHashPassword());
			if(ObjectUtils.isEmpty(userResponse)) 
			{
				String message = "login faild . please try again ! ";
				model.addAttribute("message", message);
				return "home/login";
			}
			else 
			{	
				session.setAttribute("currentUser", userResponse);
				return "redirect:/index";
			}
		}
		
		@GetMapping("/logout")
		public String doGetLogout(HttpSession session) {
			session.removeAttribute("currentCart");
			session.removeAttribute("currentUser");
			return "redirect:/index";
		}
		
		@GetMapping("/register")
		public String doGetRegister(Model model) {
			model.addAttribute("user", new Users());
			return "home/register";
		}
		
		@PostMapping("/register")
		public String doPostRegister(Model model,
				@ModelAttribute("user") Users userRequest,
				HttpSession session) {
			Users userResponse = userService.save(userRequest);
			
			if (ObjectUtils.isEmpty(userResponse)) {
				model.addAttribute("message", "Register failed, please try again!");
				return "home/register";
			} else {
				session.setAttribute(SessionConst.CURRENT_USER, userResponse);
				return "redirect:/index";			
			}
		}
		
		
		
		
		
}
