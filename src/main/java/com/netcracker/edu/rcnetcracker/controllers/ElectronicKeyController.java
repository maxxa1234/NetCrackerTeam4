package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Ekey;
import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.filtering.EntitySpecification;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("keys")
@RestController
public class ElectronicKeyController {

    @Autowired
    private EntityServiceImpl<Ekey> service;

    @GetMapping(params = {"size"})
    public List<Ekey> getAllKeys(@RequestParam("size") int size) {
        return service.findPagination(size);
    }

    @GetMapping(value = "/filter",
            params = {"key", "operation", "value"})
    public List<Ekey> getAllEntrancesFiltered(@RequestParam("key") String key, @RequestParam("operation") String operation, @RequestParam("value") User value) {
        return service.getFiltrated(new EntitySpecification<>(new SearchCriteria(key, operation, value)));
    }

    @PostMapping("/add")
    public void createKey(@RequestBody Ekey ekey) {

    }

    @DeleteMapping("{id}")
    public void deleteKey(@PathVariable("id") Long keyID) {

    }

    @PutMapping("{id}")
    public void updateKey(@PathVariable("id") Long keyID) {

    }

}
