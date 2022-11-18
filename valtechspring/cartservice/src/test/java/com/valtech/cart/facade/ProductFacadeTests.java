package com.valtech.cart.facade;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import com.valtech.cart.vo.ProductVO;

@SpringBootTest // Please write unit test cases for all methods in facade..
public class ProductFacadeTests {
	
	@Autowired
	private ProductFacade productFacade;
	
	@Test
	public void testAddSub()	{
		List<ProductVO> products = productFacade.getProducts();
		ProductVO p = products.get(0);
		
		ProductVO p1 = productFacade.addQuantity(p.getId(), 5);
		assertEquals(p.getQuantity()+5,p1.getQuantity());
	}
	
	
	@Test
	public void testProducts()	{
		List<ProductVO> products = productFacade.getProducts();
		assertEquals(3, products.size());
	}

}
