package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.UtilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;


@RequestMapping("utilities")
@RestController
public class UtilitiesController {

    private final UtilitiesService service;

    @Autowired
    public UtilitiesController(UtilitiesService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Utility> getAll(@RequestParam(value = "page", required = false) int page,
                                @RequestParam(value = "size", required = false) int size,
                                @RequestParam(value = "bankBook", required = false) String bankBook,
                                @RequestParam(value = "dateFrom", required = false) String dateFrom,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "dateTo", required = false) String dateTo,
                                @RequestParam(value = "currentMonthReading", required = false) String currentMonthReading,
                                @RequestParam(value = "status", required = false) String status,
                                @RequestParam(value = "serviceID", required = false) String serviceID,
                                @RequestParam(value = "sort", required = false)String sort) {

        return null;
    }

    @GetMapping(params = {"id"})
    public void getUtility(@RequestParam("id") Long utilityID) {
        service.getById(utilityID);
    }

    @PostMapping("/add")
    public void createUtility(@RequestBody Utility utility) {
        service.create(utility);
    }

    @PutMapping(value = "/attachPhoto/{id}")
    public void attachPhoto(@PathVariable("id")Long id, @RequestParam(value = "photoURL", required = true) String photoURL) {

    }

}
