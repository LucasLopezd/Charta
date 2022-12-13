package com.wallet.wallet.api.controller;

import com.wallet.wallet.api.service.IUserService;
import com.wallet.wallet.domain.dto.request.AuthenticationRequest;
import com.wallet.wallet.domain.dto.request.UserRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.wallet.wallet.handler.ResponseBuilder.*;


@RestController
@RequestMapping("/users")
@CrossOrigin
public record UserController(IUserService service) {

    @Operation(summary = "Guardar o actualizar un Usuario")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequestDto dto) {
        return responseBuilder(CREATED, service.save(dto));
    }

    @Operation(summary = "Log in de Usuario")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest dto) {
        return responseBuilder(OK, service.authenticate(dto));
    }

    @Operation(summary = "Pasar rol de Pending a USER")
    @PostMapping("/validate")
    public ResponseEntity<?> validate(@RequestBody AuthenticationRequest dto) {
        return responseBuilder(OK, service.validate(dto));
    }
}
