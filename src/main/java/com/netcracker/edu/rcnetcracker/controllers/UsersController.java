package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.UsersService;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UsersController {


    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }

    @GetMapping
    public Page<User> getAll(@RequestParam(value = "page", required = false) int page,
                             @RequestParam(value = "size", required = false) int size,
                             @RequestParam(value = "email", required = false) String email,
                             @RequestParam(value = "firstName", required = false) String firstName,
                             @RequestParam(value = "lastName", required = false) String lastName,
                             @RequestParam(value = "patronymic", required = false) String patronymic,
                             @RequestParam(value = "isActive", required = false) String isActive,
                             @RequestParam(value = "receiveUtilityNotification", required = false) String receiveUtilityNotification,
                             @RequestParam(value = "roleID", required = false) String roleID,
                             @RequestParam(value = "sort", required = false) String sort) {

        return null;
    }

    @PostMapping("/add")
    public void createUser(@RequestBody User user) {
        service.create(user);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable("id") User id) {
        service.update(id);
    }

    @DeleteMapping(params = {"id"})
    public void deleteUser(@RequestParam("id") Long userId) {
        service.delete(userId);
    }


}
