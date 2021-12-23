package com.online.OnlineProductDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.OnlineProductDeliverySystem.Entity.Order;

import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
