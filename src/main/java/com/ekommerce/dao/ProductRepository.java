package com.ekommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
