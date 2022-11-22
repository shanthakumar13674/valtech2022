package com.valtech.products.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.products.entity.Product;
import com.valtech.products.repository.ProductRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getProduct(long id)	{
		logger.info("Fetching Product with id "+id);
		Product p = productRepository.findById(id).get();
		logger.debug("Product fetched with id = "+id+" is "+p);
		return p;
	}
	
	@Override
	public Product saveProduct(Product prod)	{
		logger.info("Saving New  Product");
		Product p = productRepository.save(prod);
		logger.debug("Product Saved with id = "+p.getId()+" is "+p);
		return p;
	}
	
	@Override
	public Product updateProduct(Product prod)	{
		logger.info("Updating Product with id "+prod.getId());
		Product p = productRepository.save(prod);
		logger.debug("Product Updated with id = "+prod.getId()+" is "+p);
		return p;
	}
	
	@Override
	public Product addQuantity(long id,int quantity)	{
		logger.debug("Add Quantity for Product id = "+id+" Quantity Added = "+quantity);
		Product prod = getProduct(id);
		logger.debug("Before adding Quantity "+prod);
		prod.setQuantity(prod.getQuantity()+quantity);
		prod = updateProduct(prod);
		logger.debug("After adding Quantity "+prod);
		return prod;
	}
	
	@Override
	public Product subQuantity(long id,int quantity)	{
		logger.debug("Subtract Quantity for Product id = "+id+" Quantity Added = "+quantity);
		Product prod = getProduct(id);
		logger.debug("Before Subtracting Quantity "+prod);
		prod.setQuantity(prod.getQuantity()-quantity);
		prod = updateProduct(prod);
		logger.debug("After Subtracting Quantity "+prod);
		return prod;
	}
	
	@Override
	public void deleteProduct(Product prod)	{
		logger.info("Deleting prod with id "+prod.getId());
		productRepository.delete(prod);
	}
	
	@Override
	public List<Product> getProducts()	{
		logger.info("Loading all Products");
		List<Product> prods = productRepository.findAll();
		logger.info("Loaded "+prods.size()+" products");
		logger.debug("Products are "+prods);
		return prods;
	}
}






