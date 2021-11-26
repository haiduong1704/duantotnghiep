package com.fpoly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.entity.Products;
import com.fpoly.repository.ProductsRepo;
import com.fpoly.service.ProductsService;



@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	private ProductsRepo repo;
	
	
	@Override
	public List<Products> findAll() {
		return repo.findAll();
	}


	@Override
	public Products findById(Long id) {
		Optional<Products> result= repo.findById(id);
		return result.isPresent() ? result.get() : null;
	}


	@Override
	public Products findBySlug(String slug) {
		// TODO Auto-generated method stub
		return null;
	}


	


	
	
}
