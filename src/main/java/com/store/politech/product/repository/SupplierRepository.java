package com.store.politech.product.repository;

import org.springframework.stereotype.Repository;

import com.store.politech.product.entity.Supplier;
import com.store.politech.shared.BaseJpaRepository;

@Repository
public interface SupplierRepository extends BaseJpaRepository<Supplier> {
}