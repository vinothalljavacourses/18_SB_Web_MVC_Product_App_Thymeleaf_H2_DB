package com.vinothit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
	public String saveProduct(@Validated @ModelAttribute("product") ProductEntity productEntity, BindingResult result,  Model model) 
	{
		
		if(result.hasErrors()) {
			return "index";
		}
		
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
    public String deleteProduct(@RequestParam("productId") Integer pId, Model model) {

		productRepo.deleteById(pId);
		model.addAttribute("msg", "Product Deleted");
		List<ProductEntity> allProducts = productRepo.findAll();

		model.addAttribute("products", allProducts);
		
		return "view";
	}
	
	@GetMapping("modifyProduct")
	public String modifyProduct(@RequestParam("productId") Integer pId, Model model) {
		
		Optional<ProductEntity> findModifyRecord = productRepo.findById(pId);
		model.addAttribute("product", findModifyRecord);
		System.out.println("model : " + model);
		return "index";
	}

}
