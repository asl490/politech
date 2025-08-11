package com.store.politech.auth.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.store.politech.auth.entity.User;
import com.store.politech.shared.BaseJpaRepository;

@Repository
public interface UserRepository extends BaseJpaRepository<User> {
    Optional<User> findByUsername(String username);
}
