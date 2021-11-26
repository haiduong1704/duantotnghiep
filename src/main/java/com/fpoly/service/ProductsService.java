package com.fpoly.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fpoly.entity.Products;



@Service
public interface ProductsService {
List<Products> findAll(); 

Products findById(Long id);
Products findBySlug(String slug);
}