package com.grownited.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.grownited.entity.CategoryEntity;
import com.grownited.entity.ProductEntity;
import com.grownited.entity.SubCategoryEntity;
import com.grownited.repository.CategoryRepository;
import com.grownited.repository.ProductRepository;
import com.grownited.repository.SubCategoryRepository;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository repoProduct;
	
	@Autowired
	CategoryRepository repoCategory;
	
	@Autowired
	SubCategoryRepository repoSubCategory;
	
	@Autowired
	Cloudinary cloudinary;
	
	@GetMapping("newproduct")
	public String newProduct(Model model) {
		
		List<CategoryEntity> allCategory = repoCategory.findAll();
		model.addAttribute("allCategory", allCategory);
		
		List<SubCategoryEntity> allSubCategory = repoSubCategory.findAll();
		model.addAttribute("allSubCategory", allSubCategory);
		
		return "NewProduct";
	}
	
	@PostMapping("saveproduct")
	public String saveProduct(ProductEntity productEntity, MultipartFile productPic1, MultipartFile productPic2, MultipartFile productPic3, Model model) {
		
		System.out.println(productPic1.getOriginalFilename());
		System.out.println(productPic2.getOriginalFilename());
		System.out.println(productPic3.getOriginalFilename());
		
		if((productPic1.getOriginalFilename().endsWith(".jpg") || productPic1.getOriginalFilename().endsWith(".png") || productPic1.getOriginalFilename().endsWith(".jpeg")) && (productPic2.getOriginalFilename().endsWith(".jpg") || productPic2.getOriginalFilename().endsWith(".png") || productPic2.getOriginalFilename().endsWith(".jpeg")) && (productPic3.getOriginalFilename().endsWith(".jpg") || productPic3.getOriginalFilename().endsWith(".png") || productPic3.getOriginalFilename().endsWith(".jpeg"))) {
			
			try {
				// product1
				Map result1 = cloudinary.uploader().upload(productPic1.getBytes(), ObjectUtils.emptyMap());
				productEntity.setProductImageURL1(result1.get("url").toString());
				
				// product2
				Map result2 = cloudinary.uploader().upload(productPic2.getBytes(), ObjectUtils.emptyMap());
				productEntity.setProductImageURL2(result2.get("url").toString());
				
				// product3
				Map result3 = cloudinary.uploader().upload(productPic3.getBytes(), ObjectUtils.emptyMap());
				productEntity.setProductImageURL3(result3.get("url").toString());
				
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		} else {
			model.addAttribute("error", "Invalid type for Product Images");
			return "NewProduct";
		}
		
		productEntity.setCreatedAt(new Date());
		
		repoProduct.save(productEntity);
		
		return "redirect:/listproduct";
	}
	
	@GetMapping("listproduct")
	public String listProduct(Model model) {
		List<ProductEntity> productList = repoProduct.findAll(); // select * from product, "productList" is a argument
		
		// how to send data from controller to jsp
		//Model
		model.addAttribute("productList", productList);
		
		return "ListProduct";
	}
	
	@GetMapping("viewproduct")
	public String viewProduct(Integer productId, Model model) {
		// ?
		Optional<ProductEntity> op = repoProduct.findById(productId);
		
		if(op.isEmpty()) {
			// not Found
		} else {
			// data found
			ProductEntity product = op.get();  //crerating object of entity, store product table into product variable
			
			// send data to jsp
			model.addAttribute("product", product);
		}
		
		return "ViewProduct";
	}
	
	
	@GetMapping("deleteproduct")
	public String deleteProduct(Integer productId) {
		
		repoProduct.deleteById(productId);  // delete from members where productId = :productId
		
		return "redirect:/listproduct";
	}
}
