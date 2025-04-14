package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grownited.dto.CartDto;
import com.grownited.entity.CartEntity;

import jakarta.transaction.Transactional;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {
	@Query(value = "select c.*, p.product_name, p.offer_price from cart c, product p where c.product_id = p.product_id", nativeQuery = true)
	List<CartDto> getAll();

	// for the update quantity in cart
	@Modifying
	@Transactional
	@Query(value = "UPDATE cart SET quantity = :quantity WHERE user_id = :userId AND product_id = :productId", nativeQuery = true)
	void updateCartQuantity(@Param("userId") Integer userId, @Param("productId") Integer productId,
			@Param("quantity") String quantity);

	// for the add to cart
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO cart (user_id, product_id, quantity) VALUES (:userId, :productId, :quantity)", nativeQuery = true)
	void insertCartItem(@Param("userId") Integer userId, @Param("productId") Integer productId,
			@Param("quantity") String quantity);

	// for the delete listed product in cart
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM cart WHERE user_id = :userId AND product_id = :productId", nativeQuery = true)
	void deleteCartItem(@Param("userId") Integer userId, @Param("productId") Integer productId);

	// for the update list product in cart
	@Query(value = "SELECT p.product_id, p.product_name, p.offer_price, c.quantity, (p.offer_price * c.quantity) AS total_price, p.product_imageurl1 "
			+ "FROM cart c JOIN product p ON c.product_id = p.product_id "
			+ "WHERE c.user_id = :userId", nativeQuery = true)
	List<Object[]> getCartItemsByUser(@Param("userId") Integer userId);
	
	// for the update badge cartitems count
	
	@Query(value = "SELECT COUNT(*) FROM cart WHERE user_id = :userId", nativeQuery = true)
	int getCartCountByUserId(@Param("userId") Integer userId);
 
	List<CartEntity> findByUserId(Integer userId);


}
