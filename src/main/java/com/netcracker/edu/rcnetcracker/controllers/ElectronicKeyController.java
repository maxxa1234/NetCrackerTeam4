package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Ekey;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.EKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("keys")
@RestController
public class ElectronicKeyController {

    @Autowired
    private EKeyService service;

    @GetMapping(params = {"page", "size"})
    public Page<Ekey> getAllKeys(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<Ekey> resultPage = service.findPagination(page, size);
        if (page > resultPage.getTotalPages()) {
//            throw new ResourceNotFoundException();
        }
        return resultPage;
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
