package com.parcialTienda.Aplicativo.web.controller;

import com.parcialTienda.Aplicativo.web.model.User;
import com.parcialTienda.Aplicativo.web.model.dto.Response;
import com.parcialTienda.Aplicativo.web.model.dto.UserRequestMessages;
import com.parcialTienda.Aplicativo.web.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Response> create(@RequestBody @Valid UserRequestMessages userRequest) {
        User user = userRequest.getRequestMessage().getUser();
        User createduser=userService.createUser(user);
        return buildResponseEntity("Usuario creado exitosamente", HttpStatus.CREATED);
    }

    private ResponseEntity<Response> buildResponseEntity(String message, HttpStatus status) {
        Response response = Response.builder()
                .responseMessage(Response.ResponseMessage.builder()
                        .date(LocalDate.now())
                        .message(Collections.singletonList(message))
                        .statusCode(status.value())
                        .build())
                .build();
        return new ResponseEntity<>(response, status);
    }
}