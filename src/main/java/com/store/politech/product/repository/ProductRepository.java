package com.store.politech.product.repository;

import org.springframework.stereotype.Repository;

import com.store.politech.product.entity.Product;
import com.store.politech.shared.BaseJpaRepository;

@Repository
public interface ProductRepository extends BaseJpaRepository<Product> {
}