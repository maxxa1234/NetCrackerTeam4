package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.UtilitiesService;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("utilities")
@RestController
public class UtilitiesController {

    private final UtilitiesService service;

    @Autowired
    public UtilitiesController(UtilitiesService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Utility> getAll(@RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "size", required = false) Integer size,
                                @RequestParam(value = "bankBook", required = false) String bankBook,
                                @RequestParam(value = "dateFrom", required = false) String dateFrom,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "dateTo", required = false) String dateTo,
                                @RequestParam(value = "currentMonthReading", required = false) String currentMonthReading,
                                @RequestParam(value = "status", required = false) String status,
                                @RequestParam(value = "serviceID", required = false) String serviceID,
                                @RequestParam(value = "sort", required = false) String sort) {
        List<SearchCriteria> filters = new ArrayList<>();
        Pageable pageable = null;
        if (page == null && size != null) {
            pageable = PageRequest.of(0, size);
        }
        if (page != null && size != null) {
            pageable = PageRequest.of(page, size);
        }
        if (bankBook != null) {
            filters.add(new SearchCriteria("bankBook", "like '%" + bankBook + "%' "));
        }
        if (dateFrom != null) {
            filters.add(new SearchCriteria("dateFrom", "like '%" + dateFrom + "%' "));
        }
        if (dateTo != null) {
            filters.add(new SearchCriteria("dateTo", "like '%" + dateTo + "%' "));
        }
        if (name != null) {
            filters.add(new SearchCriteria("name", "like '%" + name + "%' "));
        }
        if (currentMonthReading != null) {
            filters.add(new SearchCriteria("currentMonthReading", "like '%" + currentMonthReading + "%' "));
        }
        if (status != null) {
            filters.add(new SearchCriteria("status", "like '%" + status + "%' "));
        }
        if (serviceID != null) {
            filters.add(new SearchCriteria("roleID", serviceID));
        }
        return service.getAll(pageable, filters, new SortCriteria(sort));
    }

    @GetMapping(params = {"id"})
    public Utility getUtility(@RequestParam("id") Long utilityID) {
        return service.getById(utilityID);
    }

    @PostMapping("/add")
    public boolean createUtility(@RequestBody Utility utility) {
        return service.create(utility);
    }

    @PutMapping(value = "/attachPhoto/{id}")
    public boolean attachPhoto(@PathVariable("id") Long id, @RequestParam(value = "photoURL", required = true) String photoURL) {
        Utility utility = service.getById(id);
        utility.setPhotoURL(photoURL);
        return service.update(utility);
    }

}
