package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.dao.Checker;
import com.netcracker.edu.rcnetcracker.dao.EntityDAO;
import com.netcracker.edu.rcnetcracker.dao.NotificationDAO;
import com.netcracker.edu.rcnetcracker.model.Notification;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RequestMapping("notification")
@RestController
public class NotificationController {
    private final NotificationDAO service;

    @Autowired
    public NotificationController(NotificationDAO service) {
        this.service = service;
    }

    @GetMapping
    public Page<Notification> getAll(@RequestParam("page") int page,
                                     @RequestParam("size") int size,
                                     @RequestParam(value = "text", required = false) String text,
                                     @RequestParam(value = "dateFrom", required = false) String dateFrom,
                                     @RequestParam(value = "dateTo", required = false) String dateTo,
                                     @RequestParam(value = "title", required = false) String title,
                                     @RequestParam(value = "categoryId", required = false) String categoryId,
                                     @RequestParam(value = "createdBy", required = false) String createdBy,
                                     @RequestParam(value = "sort", required = false) String sort) {
        EntityDAO<Notification> ser = new EntityDAO<>(service);
        List<SearchCriteria> filterParameters = new ArrayList<>();
        if (text != null)
            filterParameters.add(new SearchCriteria("text", text));
        if (dateFrom != null) {
            Checker.checkDateParameter(dateFrom);
            filterParameters.add(new SearchCriteria("dateFrom", dateFrom));
        }
        if (dateTo != null) {
            Checker.checkDateParameter(dateTo);
            filterParameters.add(new SearchCriteria("dateTo", dateTo));
        }
        if (title != null)
            filterParameters.add(new SearchCriteria("title", title));
        if (categoryId != null) {
            Checker.checkNumParameter(categoryId);
            filterParameters.add(new SearchCriteria("categoryId", categoryId));
        }
        if (createdBy != null) {
            Checker.checkNumParameter(createdBy);
            filterParameters.add(new SearchCriteria("createdBy", createdBy));
        }

        return ser.getAll(page, size, filterParameters, sort);
    }

    @PostMapping("/utility/{utilityNotificationId}/{apartmentId}/{date}")
    public void postUtilityNotification(Long utilityId, Long utilityNotificationId, Long apartmentId, Date date) {

    }

    @PostMapping("/routine/{entranceId}")
    public void postRoutineNotification(@PathVariable("entranceId") Long entersId) {

    }

    @GetMapping("/routine/actual/{apartmentId}")
    public void getActualRoutineNotificationsByApartment(@PathVariable("apartmentId") Long apartmentId) {

    }

    @GetMapping("/utility/actual/{apartmentId}")
    public void getActualUtilityNotificationsByApartment(@PathVariable("apartmentId") Long apartmentId) {

    }
}
