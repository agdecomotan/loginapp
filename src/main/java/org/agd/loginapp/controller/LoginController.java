package org.agd.loginapp.controller;

import org.agd.loginapp.model.Login;
import org.agd.loginapp.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by AGD on 12/1/2019.
 */
@RestController
@RequestMapping("/api/v1/test")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/dates")
    public List<Login> getLogins() {
        return loginRepository.findAll();
    }
}
