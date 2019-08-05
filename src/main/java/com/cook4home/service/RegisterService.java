package com.cook4home.service;

import com.cook4home.model.Register;
import com.cook4home.pojo.Login;
import com.cook4home.reposiotory.RegisterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {

    final RegisterRepository registerRepository;

    public Boolean registerCook(Register register) {
        registerRepository.save(register);
        return true;
    }

    public Register checkLogin(Login login) {
        return registerRepository.findByEmail(login.getEmail());
    }
}
