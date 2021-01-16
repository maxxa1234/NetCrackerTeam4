package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.dto.AuthRequest;
import com.netcracker.edu.rcnetcracker.dto.AuthResponse;
import com.netcracker.edu.rcnetcracker.dto.RegistrationRequest;
import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.TokenService;
import com.netcracker.edu.rcnetcracker.servicies.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@RestController
public class AuthController {
    private static final String AUTHORIZATION = "Authorization";

    private UsersService usersService;
    private TokenService tokenService;

    @Autowired
    public AuthController(UsersService usersService, TokenService tokenService) {
        this.usersService = usersService;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public String registration(@RequestBody @Valid RegistrationRequest registrationRequest) {
        User user = new User();
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        usersService.create(user);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = usersService.findByLoginAndPass(request.getEmail(), request.getPassword());
        String token = tokenService.createToken(user.getEmail());
        return new AuthResponse(token);
    }

    @GetMapping("/current")
    public User currentUser(ServletRequest req) {
        HttpServletRequest request = (HttpServletRequest) req;
        String token = request.getHeader(AUTHORIZATION);
        String userEmail = tokenService.getUserEmailFromToken(token);
        return usersService.findUserByEmail(userEmail);
    }
}
