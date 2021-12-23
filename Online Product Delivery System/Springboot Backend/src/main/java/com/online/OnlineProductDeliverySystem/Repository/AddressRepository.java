package com.online.OnlineProductDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.OnlineProductDeliverySystem.Entity.Address;
import org.springframework.stereotype.Repository;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
}