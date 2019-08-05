package com.cook4home.controller;

import com.cook4home.model.Register;
import com.cook4home.pojo.Login;
import com.cook4home.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class RegisterController {

    final RegisterService registerService;

    @PostMapping(value = "/register")
    public Boolean registerCook(@RequestBody Register register) {
        registerService.registerCook(register);
        return true;
    }

    @GetMapping(value = "/login")
    public ResponseEntity<?> login(@Valid @RequestBody Login login) {
        Register register = registerService.checkLogin(login);
        return new ResponseEntity(register, register == null ? HttpStatus.UNAUTHORIZED : HttpStatus.OK);
    }
}
