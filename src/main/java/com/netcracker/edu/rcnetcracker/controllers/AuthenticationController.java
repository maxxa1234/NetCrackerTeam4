package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.MailSenderService;
import com.netcracker.edu.rcnetcracker.servicies.UsersService;
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

    public AuthenticationController(UsersService usersService, JdbcTemplate jdbcTemplate, MailSenderService mailSenderService) {
        this.usersService = usersService;
        this.jdbcTemplate = jdbcTemplate;
        this.mailSenderService = mailSenderService;
    }

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) throws Exception {

        if (!checkUser(user.getEmail())) {
            throw new Exception("user with such email (" + user.getEmail() + ") already exists.");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        user.setActivationCode(UUID.randomUUID().toString()); //создаём активационный код

        usersService.create(user);
        System.out.println();
        String message = String.format(
                "Hello, %s! \n" +
                        "You are welcome! Please, visit next link: http://localhost:8085/activate/%s",
                user.getLastName(),
                user.getActivationCode()
        );
        mailSenderService.sendEmail("testingsender12368@gmail.com", "Activation code", message);


        if (!StringUtils.isEmpty(user.getEmail())) {
//            String message = String.format(
//                    "Hello, %s! \n" +
//                            "You are welcome! Please, visit next link: http://localhost:8085/activate/%s",
//                    user.getLastName(),
//                    user.getActivationCode()
//            );
//            mailSenderService.sendEmail(user.getEmail(), "Activation code", message);

//            mailSenderService.sendEmail("testingsender12368@gmail.com", "Activation code", message);

        }
        //usersService.create(user);

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


    private boolean checkUser(String username) {
        User user = usersService.findUserByEmail(username);
        return user == null;
    }

    /**
     * Можно использовать userService для CRUD операций
     * */
    private void save(User user) {
        String query = "INSERT INTO objects(object_id, object_type_id) VALUES" + " (203, 10)";
        String query1 = "INSERT INTO attributes(attr_id, object_id, value) VALUES" + " (21, 203" + ", '" + user.getEmail() + "')";
        String query2 = "INSERT INTO attributes(attr_id, object_id, value) VALUES" + " (22, 203" + ", '" + user.getPassword() + "')";
        String query3 = "INSERT INTO attributes(attr_id, object_id, value) VALUES" + " (23, 203" + ", '" + user.getFirstName() + "')";
        String query4 = "INSERT INTO attributes(attr_id, object_id, value) VALUES" + " (24, 203" +
                "" + ", '" + user.getLastName() + "')";
        String query5 = "INSERT INTO attributes(attr_id, object_id, value) VALUES" + " (55, 203" + ", '" + user.getActivationCode() + "')";

        jdbcTemplate.execute(query);
        jdbcTemplate.execute(query1);
        jdbcTemplate.execute(query2);
        jdbcTemplate.execute(query3);
        jdbcTemplate.execute(query4);
        jdbcTemplate.execute(query5);

    }

    /**
     * Можно использовать getById из userService
    * */
    private void findUserById(Long id) {
        String query = "SELECT * FROM attributes WHERE OBJECT_ID = " + id;

        jdbcTemplate.execute(query);
//        return user???
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

        return null; //страничку пользователя
    }
}
