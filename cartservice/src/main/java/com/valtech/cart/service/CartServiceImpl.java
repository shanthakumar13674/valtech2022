package com.valtech.cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.cart.entity.Cart;
import com.valtech.cart.entity.LineItem;
import com.valtech.cart.facade.ProductFacade;
import com.valtech.cart.repository.CartRepository;
import com.valtech.cart.repository.LineItemRepository;
import com.valtech.cart.vo.ProductVO;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private LineItemRepository lineItemRepository;
	@Autowired
	private ProductFacade productFacade;
	
	@Override
	public Cart createCart()		{
		return cartRepository.save(new Cart());
	}
	
	@Override
	public Cart getCart(long id)	{
		return cartRepository.findById(id).get();
	}
	
	@Override
	public Cart addLineItem(long cartId,long productId,int quantity)	{
		// Get the Cart
		Cart cart = cartRepository.findById(cartId).get();
		// Get the product..
		ProductVO prod = productFacade.getProduct(productId);
		// check quantity available
		// create a line item and save
		System.out.println("Product .. "+prod);
		LineItem item = lineItemRepository.save(new LineItem(productId,quantity,prod.getCost()*quantity,prod.getTax()*quantity));
		// add line item to cart
		cart.addLineItem(item);
		// savee the cart
		return cartRepository.save(cart);
	}
	
	@Override
	public Cart checkOut(long cartid)	{
		Cart cart = cartRepository.findById(cartid).get();
		cart.setCheckedOut(true);
		// update all item quantity in the Product service;
		return cartRepository.save(cart);
	}

}
