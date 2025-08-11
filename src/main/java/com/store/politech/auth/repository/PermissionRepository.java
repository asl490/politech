package com.store.politech.auth.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.store.politech.auth.entity.Permission;
import com.store.politech.shared.BaseJpaRepository;

@Repository
public interface PermissionRepository extends BaseJpaRepository<Permission> {
    Optional<Permission> findByName(String name);
}
