package com.online.OnlineProductDeliverySystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.online.OnlineProductDeliverySystem.Entity.Address;
import com.online.OnlineProductDeliverySystem.Entity.Cart;
import com.online.OnlineProductDeliverySystem.Entity.Customer;
import com.online.OnlineProductDeliverySystem.Entity.Product;
import com.online.OnlineProductDeliverySystem.Repository.CartRepository;
import com.online.OnlineProductDeliverySystem.Service.AddressService;
import com.online.OnlineProductDeliverySystem.Service.CustomerService;
import com.online.OnlineProductDeliverySystem.Service.ProductService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("")
	public List<Customer> findAll(){
		return customerService.viewAllCustomers();
	}
	
	@GetMapping("customer")
	public Customer getOne(@PathVariable("id") Integer customerId) {
		return customerService.viewCustomer(customerId);
	}
	@PostMapping(value = "/create",
	        consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return ResponseEntity.ok(customer);
	}
	@PutMapping("/{id}/update")
    public ResponseEntity edit(@PathVariable("id") Integer customerId,
                               @RequestBody Customer customer) {
		customer.setCustomerId(customerId);
		customerService.updateCustomer(customer);
        return ResponseEntity.ok( customer);
    }
	@DeleteMapping("/{id}/delete")
    public ResponseEntity delete(@PathVariable("id") Integer customerId) {
		Customer customer = customerService.viewCustomer(customerId);
        customerService.removeCustomerById(customerId);
        return ResponseEntity.ok().build();
    }
	
	@PostMapping("/{id}/address/{aid}/create")
	public Address addAddress(@PathVariable("id") Integer customerId, @PathVariable("aid") Integer addressId  ) {
		return customerService.addAddress(customerId, addressId);
	}
	
}