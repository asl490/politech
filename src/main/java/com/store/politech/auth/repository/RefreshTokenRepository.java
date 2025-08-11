package com.store.politech.auth.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.store.politech.auth.entity.RefreshToken;
import com.store.politech.auth.entity.User;
import com.store.politech.shared.BaseJpaRepository;

@Repository
public interface RefreshTokenRepository extends BaseJpaRepository<RefreshToken> {
    Optional<RefreshToken> findByToken(String token);

    Optional<RefreshToken> findByUserId(Long userId);

    void deleteByUser(User user);
}