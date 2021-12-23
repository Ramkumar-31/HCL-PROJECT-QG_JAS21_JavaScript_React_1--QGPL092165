package com.online.OnlineProductDeliverySystem.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.online.OnlineProductDeliverySystem.Entity.Cart;
import org.springframework.stereotype.Repository;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}