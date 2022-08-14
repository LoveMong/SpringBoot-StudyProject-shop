package com.shop.repository;

import com.shop.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartReposiitory extends JpaRepository<Cart, Long> {
}

