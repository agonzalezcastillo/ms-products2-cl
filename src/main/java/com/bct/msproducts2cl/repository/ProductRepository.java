package com.bct.msproducts2cl.repository;

import com.bct.msproducts2cl.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
