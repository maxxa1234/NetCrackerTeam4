package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.dto.AuthRequest;
import com.netcracker.edu.rcnetcracker.dto.AuthResponse;
import com.netcracker.edu.rcnetcracker.model.ActivationMessage;
import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.MailSenderService;
import com.netcracker.edu.rcnetcracker.servicies.TokenService;
import com.netcracker.edu.rcnetcracker.servicies.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@RestController
public class AuthController {
    private static final String AUTHORIZATION = "Authorization";

    private final UsersService usersService;
    private final TokenService tokenService;
    private final MailSenderService mailSenderService;

    @Value("${server.port}")
    String serverPortName;

    @Autowired
    public AuthController(UsersService usersService, TokenService tokenService, MailSenderService mailSenderService) {
        this.usersService = usersService;
        this.tokenService = tokenService;
        this.mailSenderService = mailSenderService;
    }

    @PostMapping("/register")
    public boolean registration(@RequestBody User user) {
        user.setActivationCode(UUID.randomUUID().toString());
        String message = String.format(
                "Hello, %s! \n" +
                        "You are welcome! Please, visit next link: http://localhost:%s/activate/%s",
                user.getLastName(),
                4200,
                user.getActivationCode()
        );
        mailSenderService.sendEmail(user.getEmail(), "Activation code", message);
        return usersService.create(user);
    }

    @GetMapping("/activate/{code}")
    public ActivationMessage activate(@PathVariable String code){
        boolean isActivated = usersService.activateUser(code);
        ActivationMessage activationMessage;
        if (isActivated) {
            activationMessage = new ActivationMessage("Success", "User successfully activated!");
        } else {
            activationMessage = new ActivationMessage("Danger", "Activation code is not found!");
        }
        return activationMessage;
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
