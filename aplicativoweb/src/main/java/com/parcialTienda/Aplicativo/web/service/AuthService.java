package com.parcialTienda.Aplicativo.web.service;

import com.parcialTienda.Aplicativo.web.controller.AuthRequest;
import com.parcialTienda.Aplicativo.web.exceptions.AuthenticationFailedException;
import com.parcialTienda.Aplicativo.web.model.User;
import com.parcialTienda.Aplicativo.web.model.dto.AuthResponse;
import com.parcialTienda.Aplicativo.web.model.enunm.ErrorMessages;
import com.parcialTienda.Aplicativo.web.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTservice jwTservice;
    private final AuthenticationManager authenticationManager;

    @SneakyThrows
    public AuthRequest  login (AuthResponse authRequest){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getEmail(), authRequest.getPassword()
            ));
        }catch (Exception e){
            throw new AuthenticationFailedException(ErrorMessages.CREDENTIAL_INVALID.getMessage());
        }
        Optional<User> user = userRepository.findByEmail(authRequest.getEmail());

        if (user.isEmpty()){
            throw new AuthenticationFailedException(ErrorMessages.CREDENTIAL_INVALID.getMessage());
        }
        UserDetails userDetails = user.get();
        String token = jwTservice.getToken(userDetails);
        return AuthRequest.builder()
                .token(token)
                .build();
    }
}