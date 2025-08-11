package com.store.politech.product.repository;

import org.springframework.stereotype.Repository;

import com.store.politech.product.entity.Category;
import com.store.politech.shared.BaseJpaRepository;

@Repository
public interface CategoryRepository extends BaseJpaRepository<Category> {
}