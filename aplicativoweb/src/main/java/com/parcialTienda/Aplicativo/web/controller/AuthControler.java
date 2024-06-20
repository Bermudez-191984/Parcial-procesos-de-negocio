package com.parcialTienda.Aplicativo.web.controller;

import com.parcialTienda.Aplicativo.web.exceptions.AuthenticationFailedException;
import com.parcialTienda.Aplicativo.web.model.dto.AuthResponse;
import com.parcialTienda.Aplicativo.web.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthControler {
    private final AuthService service;
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthResponse authRequest){
        try {
            AuthRequest authResponse = service.login(authRequest);
            return ResponseEntity.ok(authResponse);
        } catch (AuthenticationFailedException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed: " + e.getMessage());
        }
    }


}