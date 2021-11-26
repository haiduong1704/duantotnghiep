package com.fpoly.service;
import com.fpoly.entity.ProductTypes;

public interface ProductTypesService {
	ProductTypes findBySlug(String slug);
}
