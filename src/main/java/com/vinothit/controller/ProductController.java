package com.vinothit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vinothit.entity.ProductEntity;
import com.vinothit.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") ProductEntity productEntity,  Model model) 
	{
		ProductEntity product = productRepo.save(productEntity);
		
		if(product.getProductId() != null) {
			model.addAttribute("msg", "Product is successfully saved...");
		}
		
		return "index";
	}
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
	
		model.addAttribute("product", new ProductEntity());
		return "index";
	}
	
	
	@GetMapping("/viewAllProducts")
	public String viewAllProducts(Model model) {
		List<ProductEntity> allProducts = productRepo.findAll();
		model.addAttribute("products", allProducts);
		return "view";
	}
	
	@GetMapping("deleteProduct")
    public String deleteProduct(@RequestParam("productId") Integer param, Model model) {
		
		productRepo.deleteById(param);
		model.addAttribute("msg", "Product Deleted");
		List<ProductEntity> allProducts = productRepo.findAll();
		model.addAttribute("products", allProducts);
		
		return "view";
	}

}
