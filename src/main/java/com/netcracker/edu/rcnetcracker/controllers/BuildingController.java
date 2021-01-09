package com.netcracker.edu.rcnetcracker.controllers;


import com.netcracker.edu.rcnetcracker.model.Building;
import com.netcracker.edu.rcnetcracker.servicies.BuildingService;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("building")
@RestController
public class BuildingController {

    private final BuildingService service;

    @Autowired
    public BuildingController(BuildingService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Building> getAll(@RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "size", required = false) Integer size,
                                 @RequestParam(value = "number", required = false) String number,
                                 @RequestParam(value = "sort", required = false) String sort) {
        List<SearchCriteria> filters = new ArrayList<>();
        Pageable pageable = null;
        if (page == null && size != null) {
            pageable = PageRequest.of(0, size);
        }
        if (page != null && size != null) {
            pageable = PageRequest.of(page, size);
        }
        if (number != null) {
            filters.add(new SearchCriteria("number", number));
        }
        return service.getAll(pageable, filters, new SortCriteria(sort));
    }

    @PostMapping("/add")
    public boolean createBuilding(@RequestBody Building building) {
        return service.create(building);
    }

    @DeleteMapping("{id}")
    public boolean deleteBuilding(@PathVariable("id") Long buildingID) {
        return service.delete(buildingID);
    }

    @PutMapping
    public boolean updateBuilding(@RequestBody Building building) {
        return service.update(building);
    }
}
