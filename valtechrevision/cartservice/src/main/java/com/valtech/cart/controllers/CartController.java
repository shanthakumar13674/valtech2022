package com.valtech.cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.cart.entity.Cart;
import com.valtech.cart.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@PostMapping("/")
	public Cart createCart()	{
		return cartService.createCart();
	}
	
	@GetMapping("/{id}")
	public Cart getCart(@PathVariable("id")long id)	{
		return cartService.getCart(id);
	}
	
	@PostMapping("/{id}/{prodId}/{quantity}")
	public Cart addProductToCart(@PathVariable("id") long cartId,@PathVariable("prodId")long prodId,@PathVariable("quantity") int quantity)	{
		return cartService.addLineItem(cartId, prodId, quantity);
	}
	
	@PostMapping("/checkout/{id}")
	public Cart checkout(@PathVariable("id") long id)	{
		return cartService.checkOut(id);
	}
	
}











