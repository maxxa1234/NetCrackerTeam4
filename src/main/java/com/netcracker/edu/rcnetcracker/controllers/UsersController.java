package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UserService service;

    @GetMapping(params = {"page", "size"})
    public Page<User> getAllUsers(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<User> resultPage = service.findPagination(page, size);
        if (page > resultPage.getTotalPages()) {
//            throw new ResourceNotFoundException();
        }
        return resultPage;
    }

    @PostMapping("/add")
    public void createUser(@RequestBody User user) {

    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable("id") User user, @RequestBody User updatingUser) {

    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") User user) {

    }
}
