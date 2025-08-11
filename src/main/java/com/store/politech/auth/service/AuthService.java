package com.store.politech.auth.service;

import com.store.politech.auth.dto.AuthResponse;
import com.store.politech.auth.dto.AuthenticationRequest;
import com.store.politech.auth.dto.RefreshTokenRequest;
import com.store.politech.auth.dto.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthenticationRequest request);

    AuthResponse refreshToken(RefreshTokenRequest request);

    void logout(RefreshTokenRequest request);
}