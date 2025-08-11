package com.store.politech.auth.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.store.politech.auth.entity.Role;
import com.store.politech.shared.BaseJpaRepository;

@Repository
public interface RoleRepository extends BaseJpaRepository<Role> {
    Optional<Role> findByName(String name);
}
