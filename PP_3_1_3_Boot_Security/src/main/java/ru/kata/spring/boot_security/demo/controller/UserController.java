package ru.kata.spring.boot_security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceConfig;

import java.security.Principal;

@RestController
//@Controller
public class UserController {

    private final UserServiceConfig userServiceConfig;

    public UserController(UserServiceConfig userServiceConfig) {
        this.userServiceConfig = userServiceConfig;
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/authenticated")
    public String authenticated(Principal principal) {
        User user = userServiceConfig.findByUsername(principal.getName());
        return "secured part of web service: " + user.getUsername() + " " + user.getEmail();
    }

    @GetMapping("/user")
    public String userPage(Principal principal) {
        User user = userServiceConfig.findByUsername(principal.getName());
        return "secured part of web service: " + user.getUsername() + " " + user.getEmail();
    }

    /*@GetMapping("/admin")
    public String adminPage(Principal principal) {
        User user = userServiceConfig.findByUsername(principal.getName());
        return "secured part of web service: " + user.getUsername() + " " + user.getEmail();
    }*/

    /*@GetMapping("/user")
    public String userPage(Principal principal) {
        //User user = userServiceConfig.findByUsername(principal.getName());
        //return "secured part of web service: " + user.getUsername() + " " + user.getEmail();
        return "showuser";
    }*/

    @GetMapping("/read_profile")
    public String pageForReadProfile() {
        return "read profile page";
    }

    @GetMapping("/only_for_admins")
    public String pageOnlyForAdmins() {
        return "admins page";
    }

}
