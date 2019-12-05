package org.agd.loginapp.controller;

import org.agd.loginapp.model.Login;
import org.agd.loginapp.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by AGD on 12/1/2019.
 */

@RestController
@RequestMapping("/api/v1/data")
public class DataController {

    @Autowired
    private LoginRepository loginRepository;

    @GetMapping("/createLogins")
    public String createLogins(@RequestParam(required = false, name = "count", defaultValue = "10") Integer count,
                             @RequestParam(required = false, name = "loginDate") @DateTimeFormat(pattern = "yyyyMMdd") Date loginDate) {

        List<Login> logins = new ArrayList<>();
        Random rand = new Random();
        Date date = loginDate != null ? loginDate : new Date();

        for (int i=0; i<count; i++)
        {
            int x = rand.nextInt(50);
            Login login = new Login();
            login.setFirstName("FName" + x);
            login.setLastName("LName" + x);
            login.setMiddleName("MName" + x);
            login.setUser("user" + x);
            login.setEmail(x + "mail@yahoo.com");
            login.setLoginTime(date);
            logins.add(login);
        }

        loginRepository.saveAll(logins);
        return "Successfully added logins.";
    }
}
