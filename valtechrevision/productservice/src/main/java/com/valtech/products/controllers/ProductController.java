package com.valtech.products.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.products.entity.Product;
import com.valtech.products.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") long id) {
		return productService.getProduct(id);
	}

	@PostMapping("/")
	public Product saveProduct(Product prod) {
		return productService.saveProduct(prod);
	}

	@PutMapping("/{id}")
	public Product updateProduct(@RequestBody Product prod,@PathVariable("id") long id) {
		return productService.updateProduct(prod);
	}

	@PostMapping("/addQuantity/{id}")
	public Product addQuantity(@PathVariable("id") long id,@RequestParam("quantity") int quantity) {
		return productService.addQuantity(id, quantity);
	}
	@PostMapping("/subQuantity/{id}")
	public Product subQuantity(@PathVariable("id") long id,@RequestParam("quantity") int quantity) {
		return productService.subQuantity(id, quantity);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") long id) {
		productService.deleteProduct(productService.getProduct(id));
	}

	@GetMapping("/")
	public List<Product> getProducts() {
		return productService.getProducts();
	}

}
