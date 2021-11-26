package com.fpoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fpoly.entity.Products;
import com.fpoly.entity.Users;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long>{
		

	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE products SET quantity =?1 WHERE id = ?2",nativeQuery = true)
	void updateQuantity(Integer quantity ,Long id);
}
