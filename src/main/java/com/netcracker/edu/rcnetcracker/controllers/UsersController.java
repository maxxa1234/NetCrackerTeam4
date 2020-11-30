package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.filtering.EntitySpecification;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private EntityServiceImpl<User> service;

    @GetMapping(params = {"size"})
    public List<User> getAllUsers(@RequestParam("size") int size) {
        return service.findPagination(size);
    }

    @GetMapping(value = "/filter",
            params = {"key", "operation", "value"})
    public List<User> getAllUsers(@RequestParam("key") String key, @RequestParam("operation") String operation, @RequestParam("value") User value) {
        List<User> results = service.getFiltrated(new EntitySpecification<>(new SearchCriteria(key, operation, value)));
        return results;
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
