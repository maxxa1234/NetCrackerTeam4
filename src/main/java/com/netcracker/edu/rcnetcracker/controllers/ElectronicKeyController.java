package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Ekey;
import com.netcracker.edu.rcnetcracker.model.User;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
@RestController
public class ElectronicKeyController {

    @PostMapping("/keys")
    public void createKey(@RequestBody Ekey ekey){

    }

    @DeleteMapping("/keys/{id}")
    public void deleteKey(@PathVariable("id")Long keyID){

    }

    @PostMapping("/resident")
    public void createUser(@RequestBody User user){

    }

    @PutMapping("/resident/{id}")
    public void updateUser(@PathVariable("id")User user, @RequestBody User updatingUser){

    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id")User user){

    }

}
