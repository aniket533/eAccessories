package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.dto.CartDto;
import com.grownited.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {
	@Query(value = "select c.*, p.product_name, p.offer_price from cart c, product p where c.product_id = p.product_id", nativeQuery = true)
	List<CartDto> getAll();
}
