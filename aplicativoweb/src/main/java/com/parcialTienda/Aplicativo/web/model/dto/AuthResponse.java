package com.parcialTienda.Aplicativo.web.model.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;
@Getter
public class AuthResponse {
    @NotBlank(message = "Email requerido")
    @Email(message = "Email no valido")
    private String email;
    @NotBlank(message = "Contraseña requerida")
    @Size(min = 8, message = "contraseña minimo 8 caracteres")
    private String password;

}