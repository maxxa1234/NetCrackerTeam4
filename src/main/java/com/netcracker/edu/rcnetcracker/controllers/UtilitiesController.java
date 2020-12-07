package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.dao.Checker;
import com.netcracker.edu.rcnetcracker.dao.EntityDAO;
import com.netcracker.edu.rcnetcracker.dao.UtilitiesDAO;
import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("utilities")
@RestController
public class UtilitiesController {

    private final UtilitiesDAO service;

    @Autowired
    public UtilitiesController(UtilitiesDAO service) {
        this.service = service;
    }

    @GetMapping
    public Page<Utility> getAll(@RequestParam("page") int page, @RequestParam("size") int size,
                                @RequestParam(value = "bankBook", required = false) String bankBook,
                                @RequestParam(value = "dateFrom", required = false) String dateFrom,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "dateTo", required = false) String dateTo,
                                @RequestParam(value = "currentMonthReading", required = false) String currentMonthReading,
                                @RequestParam(value = "status", required = false) String status,
                                @RequestParam(value = "serviceID", required = false) String serviceID,
                                @RequestParam(value = "sort", required = false)String sort) {
        List<SearchCriteria> filterParameters = new ArrayList<>();
        EntityDAO<Utility> ser = new EntityDAO<>(service);
        if (bankBook != null)
            filterParameters.add(new SearchCriteria("bankBook", "like %"+bankBook+"% "));
        if (name != null)
            filterParameters.add(new SearchCriteria("name", "like %"+name+"% "));
        if (dateFrom != null) {
            Checker.checkDateParameter(dateFrom);
            filterParameters.add(new SearchCriteria("dateFrom", dateFrom));
        }
        if (dateTo != null) {
            Checker.checkDateParameter(dateTo);
            filterParameters.add(new SearchCriteria("dateTo", dateTo));
        }
        if (currentMonthReading != null) {
            Checker.checkNumParameter(currentMonthReading);
            filterParameters.add(new SearchCriteria("currentMonthReading", currentMonthReading));
        }
        if (status != null) {
            Checker.checkBooleanParameter(status);
            filterParameters.add(new SearchCriteria("status", status));
        }
        if (serviceID != null) {
            Checker.checkNumParameter(serviceID);
            filterParameters.add(new SearchCriteria("serviceID", serviceID));
        }

        return ser.getAll(page, size, filterParameters, sort);
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
