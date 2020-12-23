package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Ekey;
import com.netcracker.edu.rcnetcracker.servicies.EkeyService;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("keys")
@RestController
public class ElectronicKeyController {

    private final EkeyService service;

    public ElectronicKeyController(EkeyService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Ekey> getAll(@RequestParam(value = "page", required = false) Integer page,
                             @RequestParam(value = "size", required = false) Integer size,
                             @RequestParam(value = "keyCode", required = false) String keyCode,
                             @RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "isActive", required = false) String isActive,
                             @RequestParam(value = "userId", required = false) String userId,
                             @RequestParam(value = "sort", required = false) String sort) {
        SortCriteria sortCriteria = null;
        List<SearchCriteria> filters = new ArrayList<>();
        Pageable pageable = null;

        if (page == null && size != null) {
            pageable = PageRequest.of(0, size);
        }
        if (page != null && size != null) {
            pageable = PageRequest.of(page, size);
        }
        if (keyCode != null) {
            filters.add(new SearchCriteria("keyCode", "like '%" + keyCode + "%' "));
        }
        if (name != null) {
            filters.add(new SearchCriteria("keyCode", "like '%" + name + "%' "));
        }
        if (isActive != null) {
            filters.add(new SearchCriteria("keyCode", "like '%" + isActive + "%' "));
        }
        if (userId != null) {
            filters.add(new SearchCriteria("keyCode", userId));
        }
        if (sort != null) {
            sortCriteria = new SortCriteria(sort);
        }
        return service.getAll(pageable, filters, sortCriteria);
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
    public void updateKey(@PathVariable("id") Ekey ekey) {
        service.update(ekey);
    }

}
