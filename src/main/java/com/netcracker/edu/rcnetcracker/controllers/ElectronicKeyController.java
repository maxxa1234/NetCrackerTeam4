package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Ekey;
import com.netcracker.edu.rcnetcracker.servicies.EkeyService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RequestMapping("keys")
@RestController
public class ElectronicKeyController {

    private final EkeyService service;

    public ElectronicKeyController(EkeyService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Ekey> getAll(@RequestParam(value = "page", required = false) int page,
                             @RequestParam(value = "size", required = false) int size,
                             @RequestParam(value = "keyCode", required = false) String keyCode,
                             @RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "isActive", required = false) String isActive,
                             @RequestParam(value = "userId", required = false) String userId,
                             @RequestParam(value = "sort", required = false) String sort) {
//        List<SearchCriteria> filterParameters = new ArrayList<>();
//        EntityDAO<Ekey> ser = new EntityDAO<>(service);
//        if (keyCode != null)
//            filterParameters.add(new SearchCriteria("keyCode", keyCode));
//        if (name != null)
//            filterParameters.add(new SearchCriteria("name", "like %"+keyCode+"% "));
//        if (isActive != null) {
//            Checker.checkBooleanParameter(isActive);
//            filterParameters.add(new SearchCriteria("isActive", isActive));
//        }
//        if (userId != null) {
//            Checker.checkNumParameter(userId);
//            filterParameters.add(new SearchCriteria("userId", userId));
//        }
//
//        return ser.getAll(page, size, filterParameters, sort);
        return null;
    }

    @PostMapping("/add")
    public void createKey(@RequestBody Ekey ekey) {
        service.create(ekey);
    }

    @DeleteMapping("{id}")
    public void deleteKey(@PathVariable("id") Long keyID) {
        service.delete(keyID);
    }

    @PutMapping("{id}")
    public void updateKey(@PathVariable("id") Long id, @RequestBody Ekey ekey) {
        BeanUtils.copyProperties(ekey, service.getById(id), "id");
//        service.save(id);
    }

}
