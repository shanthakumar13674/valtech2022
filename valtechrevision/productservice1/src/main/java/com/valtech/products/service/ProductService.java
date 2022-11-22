package com.valtech.products.service;

import java.util.List;

import com.valtech.products.entity.Product;

public interface ProductService {

	Product getProduct(long id);

	Product saveProduct(Product prod);

	Product updateProduct(Product prod);

	Product addQuantity(long id, int quantity);

	Product subQuantity(long id, int quantity);

	void deleteProduct(Product prod);

	List<Product> getProducts();

}