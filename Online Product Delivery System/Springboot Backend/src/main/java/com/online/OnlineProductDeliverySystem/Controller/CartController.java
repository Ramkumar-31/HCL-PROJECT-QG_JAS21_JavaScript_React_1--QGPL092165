package com.online.OnlineProductDeliverySystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.OnlineProductDeliverySystem.Entity.Cart;
import com.online.OnlineProductDeliverySystem.Service.CartService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class CartController {
	@Autowired
	private CartService cartService;	
	@GetMapping("/{cid}/cart")
	public Cart getCart(@PathVariable("cid") Integer customerId) {
		return cartService.getCustomerCart(customerId);
	}
	
	@PostMapping("/{cid}/cart/add-product/{pid}")
	public Cart addProduct(@PathVariable("cid") Integer customerId,@PathVariable("pid") Integer productId) {
		return cartService.addProductToCart(productId, customerId);
	}
	
	@DeleteMapping("/{cid}/cart/remove-product/{pid}")
	public void removeProduct(@PathVariable("cid") Integer customerId,@PathVariable("pid") Integer productId) {
		cartService.removeProductFromCart(customerId, productId);
	}
	@DeleteMapping("/{cid}/cart/remove-products")
	public void removeAllProducts(@PathVariable("cid") Integer customerId) {
		cartService.removeAllProducts(customerId);
	}
}