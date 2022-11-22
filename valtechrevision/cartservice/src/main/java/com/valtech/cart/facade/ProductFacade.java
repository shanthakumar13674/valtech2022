package com.valtech.cart.facade;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.valtech.cart.vo.ProductVO;


@Component
// Facade as a design pattern is fundamentally used for hiding the complexity of calling a service.
public class ProductFacade {
	
	@Autowired
	private RestTemplate restTemplate;
	private static final String PRODUCTS_URL="http://PRODUCTSERVICE/api/products";
	
	public ProductVO getProduct(long id)	{
		return restTemplate.getForObject(PRODUCTS_URL+"/"+id, ProductVO.class);
	}

	// not necessary .. coz cart will not save a new product
	public ProductVO saveProduct(ProductVO prod)	{
		return restTemplate.postForObject(PRODUCTS_URL+"/", prod, ProductVO.class);
	}

	public ProductVO updateProduct(ProductVO prod)	{
		 restTemplate.put(PRODUCTS_URL+"/"+prod.getId(), prod);
		 return getProduct(prod.getId());
	}

	public ProductVO addQuantity(long prodId, int quantity)	{
		Map<String,Integer> params = new HashMap<>();
		return restTemplate.postForObject(PRODUCTS_URL+"/addQuantity/"+prodId+"?quantity="+quantity, null, ProductVO.class);
	}

	public ProductVO subQuantity(long prodId, int quantity)	{
		return restTemplate.postForObject(PRODUCTS_URL+"/subQuantity/"+prodId+"?quantity="+quantity, null, ProductVO.class );
	}

	// Not necessary.. Cart will not delete.
	public void deleteProduct(ProductVO prod)	{
		restTemplate.delete(PRODUCTS_URL+"/"+prod.getId());
	}

	public List<ProductVO> getProducts()	{
		return Arrays.asList(restTemplate.getForObject(PRODUCTS_URL+"/", ProductVO[].class));
	}

}
