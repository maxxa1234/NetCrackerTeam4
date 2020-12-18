package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.servicies.EntranceService;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/entrance")
@RestController
public class EntranceController {

    private final EntranceService service;

    public EntranceController(EntranceService service) {
        this.service = service;
    }

    @Autowired
    private OracleDbAccess oracleDbAccess;

    @GetMapping(value = "/open",
            params = {"key_id", "entrance_id"})
    public boolean openGate(@RequestParam("key_id") Long key_id, @RequestParam("entrance_id") Long entrance_id) {
        //will return isOpened
        return false;
    }

    @GetMapping(value = "/block",
            params = {"key_id", "entrance_id"})
    public boolean blockGate(@RequestParam("key_id") Long key_id, @RequestParam("entrance_id") Long entrance_id) {
        //will return isBlock
        return false;
    }

    @PostMapping("/add")
    public void createEntrance(@RequestBody Entrance entrance) {
        service.create(entrance);
    }

    @DeleteMapping(params = {"id"})
    public void deleteEntrance(@RequestParam("id") Long entranceId) {
        service.delete(entranceId);
    }

    @PutMapping("{id}")
    public void updateEntrance(@PathVariable("id") Entrance object) {
        service.update(object);
    }

    @GetMapping
    public Page<Entrance> getAll(@RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "size", required = false) Integer size,
                                 @RequestParam(value = "typeId", required = false) String typeId,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "buildingId", required = false) String buildingId,
                                 @RequestParam(value = "isActive", required = false) String isActive,
                                 @RequestParam(value = "sort", required = false) String sort) {
        SortCriteria sortCriteria = null;
        List<SearchCriteria> filters = new ArrayList<>();
        Pageable pageable = null;
        if (page != null || size != null)
            pageable = PageRequest.of(page, size);
        if (typeId != null) {
            filters.add(new SearchCriteria("typeId", typeId));
        }
        if (name != null) {
            filters.add(new SearchCriteria("name", "like '%" + name + "%' "));
        }
        if (buildingId != null) {
            filters.add(new SearchCriteria("buildingId","like '%" + buildingId+"%' "));
        }
        if (isActive != null) {
            filters.add(new SearchCriteria("isActive", "like '%"+isActive+"%' "));
        }
        if (sort != null) {
            sortCriteria = new SortCriteria(sort);
        }
        return service.getAll(pageable, filters, sortCriteria);
    }

    @GetMapping("/log")
    public void getLog(@RequestParam("page") int page, @RequestParam("size") int size,
                       @RequestParam(value = "filter", required = false) String filter,
                       @RequestParam(value = "sort", required = false) String sort) {

    }

    @RequestMapping(value = "/get-one/{id}")
    public Entrance getOne(@PathVariable("id") Long id) {
        return service.getById(id);
    }

}
