package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.filtering.EntitySpecification;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {

//    @Autowired
//    private UserRepository repository;

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

    @GetMapping(params = {"key", "operation", "value"})
    public List<User> getAllUsers(@RequestParam("key")String key, @RequestParam("operation")String operation, @RequestParam("value")User value){
        EntitySpecification<User> userSpecification = new EntitySpecification<>(new SearchCriteria(key, operation, value));
//        List<User> results = repository.findAll(Specification.where(userSpecification));
//        return results;
        return null;
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
