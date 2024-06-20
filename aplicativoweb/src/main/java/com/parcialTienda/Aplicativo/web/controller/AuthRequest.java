package com.parcialTienda.Aplicativo.web.controller;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class AuthRequest {
    private String token;
}