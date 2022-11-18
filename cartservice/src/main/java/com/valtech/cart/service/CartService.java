package com.valtech.cart.service;

import com.valtech.cart.entity.Cart;

public interface CartService {

	Cart createCart();

	Cart getCart(long id);

	Cart addLineItem(long cartId, long productId, int quantity);

	Cart checkOut(long cartid);

}