package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("utilities")
@RestController
public class UtilitiesController {

    @Autowired
    private EntityServiceImpl<Utility> service;

    @GetMapping(params = {"size"})
    public List<Utility> getAllUtilities(@RequestParam("size") int size) {
        return service.findPagination(size);
    }

    @GetMapping("{id}")
    public void getUtility(@PathVariable("id") Long utilityID) {

    }

    @PostMapping("/add")
    public void createUtility() {

    }

    @PostMapping(value = "/attachPhoto",
            params = {"utilityId", "photoURL"})
    public void attachPhoto(@RequestParam("utilityId") Long utilityId, @RequestParam("photoURL") String photoURL) {

    }

}
