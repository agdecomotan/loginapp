package org.agd.loginapp.controller;

import org.agd.loginapp.model.Login;
import org.agd.loginapp.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by AGD on 12/1/2019.
 */
@RestController
@RequestMapping("/api/v1/test")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    //Get logins by date
    @GetMapping("/dates")
    public List<Date> getDates() {
        return loginRepository.getDates();
    }

    @GetMapping("/users")
    public List<String> getUsers(@RequestParam(required = false, name = "start") @DateTimeFormat(pattern = "yyyyMMdd") Date startDate,
                                 @RequestParam(required = false, name = "end") @DateTimeFormat(pattern = "yyyyMMdd") Date endDate) {
        return loginRepository.getUsers(startDate, endDate);
    }

    @GetMapping("/logins")
    public List<Map<String, Integer>> getLogins(@RequestParam(required = false, name = "start") @DateTimeFormat(pattern = "yyyyMMdd") Date startDate,
                         @RequestParam(required = false, name = "end") @DateTimeFormat(pattern = "yyyyMMdd") Date endDate,
                         @RequestParam(required = false, name = "user", defaultValue = " ") List<String> user,
                         @RequestParam(required = false, name = "firstName", defaultValue = " ") List<String> firstName,
                         @RequestParam(required = false, name = "middleName", defaultValue = " ") List<String> middleName,
                         @RequestParam(required = false, name = "lastName", defaultValue = " ") List<String> lastName,
                         @RequestParam(required = false, name = "emailAddress", defaultValue = " ") List<String> emailAddress) {
        return loginRepository.getLogins(startDate, endDate, user, firstName, middleName, lastName, emailAddress);
    }

    @GetMapping("/loginTest")
    public List<Login> getLoginsTest(@RequestParam(required = false, name = "user", defaultValue = " ") List<String> user) {
        return loginRepository.getLoginsTest(user);
    }
}
