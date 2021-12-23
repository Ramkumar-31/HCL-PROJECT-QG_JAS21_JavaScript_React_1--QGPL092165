package com.online.OnlineProductDeliverySystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.OnlineProductDeliverySystem.Entity.User;

import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}