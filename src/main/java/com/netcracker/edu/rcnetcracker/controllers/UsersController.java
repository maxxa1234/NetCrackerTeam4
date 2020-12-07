package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.dao.Checker;
import com.netcracker.edu.rcnetcracker.dao.EntityDAO;
import com.netcracker.edu.rcnetcracker.dao.UsersDAO;
import com.netcracker.edu.rcnetcracker.model.Ekey;
import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {


    private final UsersDAO service;

    public UsersController(UsersDAO service) {
        this.service = service;
    }

    @GetMapping
    public Page<User> getAll(@RequestParam("page") int page, @RequestParam("size") int size,
                             @RequestParam( value = "email", required = false) String email,
                             @RequestParam( value = "firstName", required = false) String firstName,
                             @RequestParam( value = "lastName", required = false) String lastName,
                             @RequestParam( value = "patronymic", required = false) String patronymic,
                             @RequestParam( value = "isActive", required = false) String isActive,
                             @RequestParam( value = "receiveUtilityNotification", required = false) String receiveUtilityNotification,
                             @RequestParam( value = "roleID", required = false) String roleID,
                             @RequestParam(value = "sort", required = false) String sort) {
        List<SearchCriteria> filterParameters = new ArrayList<>();
        EntityDAO<User> ser = new EntityDAO<>(service);
        if (email != null)
            filterParameters.add(new SearchCriteria("email", email));
        if (isActive != null) {
            Checker.checkBooleanParameter(isActive);
            filterParameters.add(new SearchCriteria("isActive", isActive));
        }
        if (firstName != null)
            filterParameters.add(new SearchCriteria("firstName", "like %"+firstName+"% "));
        if (lastName != null)
            filterParameters.add(new SearchCriteria("lastName", "like %"+lastName+"% "));
        if (patronymic != null)
            filterParameters.add(new SearchCriteria("patronymic", "like %"+patronymic+"% "));
        if (receiveUtilityNotification != null) {
            Checker.checkBooleanParameter(receiveUtilityNotification);
            filterParameters.add(new SearchCriteria("receiveUtilityNotification", receiveUtilityNotification));
        }
        if (roleID != null) {
            Checker.checkNumParameter(roleID);
            filterParameters.add(new SearchCriteria("roleID", roleID));
        }

        return ser.getAll(page, size, filterParameters, sort);
    }

    @PostMapping("/add")
    public void createUser(@RequestBody User user) {
        service.create(user);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable("id")Long id) {
        service.update(id);
    }

    @DeleteMapping(params = {"id"})
    public void deleteUser(@RequestParam("id") Long userId) {
        service.delete(userId);
    }
}
