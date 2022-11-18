package com.valtech.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.products.entity.Product;
import com.valtech.products.repository.ProductRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getProduct(long id)	{
		return productRepository.findById(id).get();
	}
	
	@Override
	public Product saveProduct(Product prod)	{
		return productRepository.save(prod);
	}
	
	@Override
	public Product updateProduct(Product prod)	{
		return productRepository.save(prod);
	}
	
	@Override
	public Product addQuantity(long id,int quantity)	{
		Product prod = getProduct(id);
		prod.setQuantity(prod.getQuantity()+quantity);
		return updateProduct(prod);
	}
	
	@Override
	public Product subQuantity(long id,int quantity)	{
		Product prod = getProduct(id);
		prod.setQuantity(prod.getQuantity()-quantity);
		return updateProduct(prod);
	}
	
	@Override
	public void deleteProduct(Product prod)	{
		productRepository.delete(prod);
	}
	
	@Override
	public List<Product> getProducts()	{
		return productRepository.findAll();
	}
}