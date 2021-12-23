package com.online.OnlineProductDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.OnlineProductDeliverySystem.Entity.Customer;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}