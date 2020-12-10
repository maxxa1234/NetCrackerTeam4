package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.UsersService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AuthenticationController {

    private final UsersService usersService;

    public AuthenticationController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/signup")
    public String register(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "user/signup";
    }

    @PostMapping("/signup")
    public String save(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        if (checkUser(user.getEmail())) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

            /*
            user.setId(user.getId());
            user.setFirstName(user.getFirstName());
            user.setLastName(user.getLastName());
            user.setEmail(user.getEmail());
            */

            usersService.create(user);
        } else {
            bindingResult.rejectValue("username", "duplicate", "this email is already in use");
            return "user/signup";
        }

        return "user/login";

//        return "redirect:/login";
    }

    @GetMapping("/account")
    public String accountPage(Principal principal, Model model) {
        User user = usersService.findUserByEmail(principal.getName());
        model.addAttribute("user", user);
        return "user/account";
    }

    private boolean checkUser(String username) {
        User user = usersService.findUserByEmail(username);
        return user == null;
    }
}
