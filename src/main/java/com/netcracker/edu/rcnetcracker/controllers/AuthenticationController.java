package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.MailSenderService;
import com.netcracker.edu.rcnetcracker.servicies.UsersService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
public class AuthenticationController {
    private final UsersService usersService;
    private final JdbcTemplate jdbcTemplate;
    private final MailSenderService mailSenderService;

    @Value("${server.port}")
    String serverPortName;

    public AuthenticationController(UsersService usersService, JdbcTemplate jdbcTemplate, MailSenderService mailSenderService) {
        this.usersService = usersService;
        this.jdbcTemplate = jdbcTemplate;
        this.mailSenderService = mailSenderService;
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) throws Exception {


//        if (!checkUser(user.getEmail())) {
//            throw new Exception("user with such email (" + user.getEmail() + ") already exists.");
//        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setActivationCode(UUID.randomUUID().toString());

        user.setId(223L); //TODO: менять айдишник пока не пофиксят

        //usersService.create(user); //TODO: раскоментить для создания
        usersService.update(user);

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "You are welcome! Please, visit next link: http://localhost:%s/activate/%s",
                    user.getLastName(),
                    serverPortName,
                    user.getActivationCode()
            );
            mailSenderService.sendEmail(user.getEmail(), "Activation code", message);
        }

        return user;
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) throws Exception {
        User userObject = null;
        if (user.getEmail() != null && user.getPassword() != null) {
            userObject = null; //find by email and password
        } else {
            if (userObject == null) {
                throw new Exception("Bad credentials");
            }
        }

        return userObject;
    }

    @GetMapping("/profile")
    public void accountPage(Principal principal) {
        Long id = findUserIdByEmail(principal.getName()).get(1);
        findUserById(id);
    }

    private void findUserById(Long id) {
        usersService.getById(id);
//        return user???
    }

    private boolean checkUser(String username) {
        User user = usersService.findUserByEmail(username);
        return user == null;
    }

    /**
     * Можно добавить фильтр и получать страничку, из которой потом извлекать контент
     * */
    private List<Long> findUserIdByEmail(String email) {
        String query = "SELECT OBJECT_ID FROM attributes WHERE value = '" + email + "'";

        System.err.println(jdbcTemplate);
        return jdbcTemplate.queryForList(query, Long.class);
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code){
        boolean isActivated = usersService.activateUser(code);

        if (isActivated) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Activation code is not found!");
        }

        return "/login";
    }
}
