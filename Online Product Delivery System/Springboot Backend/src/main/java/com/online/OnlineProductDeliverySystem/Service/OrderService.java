package com.online.OnlineProductDeliverySystem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.OnlineProductDeliverySystem.Entity.Customer;
import com.online.OnlineProductDeliverySystem.Entity.Order;
import com.online.OnlineProductDeliverySystem.Entity.Product;
import com.online.OnlineProductDeliverySystem.Repository.AddressRepository;
import com.online.OnlineProductDeliverySystem.Repository.CustomerRepository;
import com.online.OnlineProductDeliverySystem.Repository.OrderRepository;
import com.online.OnlineProductDeliverySystem.Repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
	
	public Order addOrder(Integer customerId,Integer productId, Order order) {
		Customer customer = customerRepository.findById(customerId).get();
		Product product = productRepository.findById(productId).get();
		order.setAddress(customer.getAddress());
		order.setCustomer(customer);
		order.setProduct(product);
		return orderRepository.save(order);
	}
	public Order updateOrder(Order order) {
		return orderRepository.save(order);
	}
	public void removeOrder(Integer orderId) {
		Order order = orderRepository.findById(orderId).get();
		Set<Product> productSet = order.getProducts();
		for( Product product: productSet ) {
			product.getOrders().remove(order);
		}
		orderRepository.delete(order);
	}
	public List<Order> viewAllOrder(){
		return orderRepository.findAll();
	}
	@Transactional
	public Order viewOrderById(Integer orderId) {
		return orderRepository.findById(orderId).get();
	}
	public List<Order> viewAllOrdersByLocation(String location){
		List<Order> listAllOrders = viewAllOrder();
		List<Order> filterByLocation = new ArrayList<Order>();
		for( Order order: listAllOrders ) {
			if( order.getAddress().getCity().equals(location) ) {
				filterByLocation.add(order);
			}
			else if(  order.getAddress().getState().equals(location) ) {
				filterByLocation.add(order);
			}
			else if( order.getAddress().getCountry().equals(location) ) {
				filterByLocation.add(order);
			}
			else if( order.getAddress().getPincode().equals(location) ) {
				filterByLocation.add(order);
			}
		}
		return filterByLocation;
	}
	
	public List<Order> viewAllOrderByUserId(Integer customerId){
		List<Order> listAllOrders = viewAllOrder();
		return listAllOrders.stream().filter( order -> order.getCustomer().getCustomerId() == customerId ).collect(Collectors.toList());
	}
	
}