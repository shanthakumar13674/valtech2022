package com.valtech.cart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
	
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private LineItemRepository lineItemRepository;
	@Autowired
	private ProductFacade productFacade;
	
	@Override
	public Cart createCart()		{
		logger.info("Creating a new Cart");
		Cart cart = cartRepository.save(new Cart());
		logger.debug("Cart successfully created "+cart);
		return cart;
	}
	
	@Override
	public Cart getCart(long id)	{
		logger.info("Loading Cart with id = "+id);
		Cart cart = cartRepository.findById(id).get();
		logger.debug("Sucessfully Loaded Cart "+cart);
		return cart;
	}
	
	@Override
	public Cart addLineItem(long cartId,long productId,int quantity)	{
		// Get the Cart
		logger.info("Loading Cart with id = "+cartId);
		Cart cart = cartRepository.findById(cartId).get();
		// Get the product..
		logger.info("Loading Product with id = "+productId);
		ProductVO prod = productFacade.getProduct(productId);
		logger.debug("Loaded Product "+prod);
		// check quantity available
		// create a line item and save
		logger.debug("Before adding the Item to Cart "+cart);
		LineItem item = lineItemRepository.save(new LineItem(productId,quantity,prod.getCost()*quantity,prod.getTax()*quantity));
		// add line item to cart
		cart.addLineItem(item);
		// savee the cart
		cart= cartRepository.save(cart);
		logger.debug("After adding the Item to Cart "+cart);
		return cart;
	}
	
	@Override
	public Cart checkOut(long cartid)	{
		logger.info("Checking out cart with id "+cartid);
		Cart cart = cartRepository.findById(cartid).get();
		cart.setCheckedOut(true);
		// update all item quantity in the Product service;
		cart= cartRepository.save(cart);
		logger.debug("After checking out the Cart "+cart);
		return cart;
	}

}