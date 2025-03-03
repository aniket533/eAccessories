package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.dto.OrderDetailDto;
import com.grownited.entity.OrderDetailEntity;

@Repository
public interface OrderDetailRepository
extends JpaRepository<OrderDetailEntity, Integer>{

	@Query(value = "select o.*, p.product_name, p.offer_price from order_detail o, product p where o.product_id = p.product_id", nativeQuery = true)
	List<OrderDetailDto> getAll();
}
