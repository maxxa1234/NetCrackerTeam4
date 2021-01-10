package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.model.Notification;
import com.netcracker.edu.rcnetcracker.servicies.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@RequestMapping("notification")
@RestController
public class NotificationController {
    private final NotificationService service;

    @Autowired
    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Notification> getAll(@RequestParam(value = "page", required = false) int page,
                                     @RequestParam(value = "size", required = false) int size,
                                     @RequestParam(value = "text", required = false) String text,
                                     @RequestParam(value = "dateFrom", required = false) String dateFrom,
                                     @RequestParam(value = "dateTo", required = false) String dateTo,
                                     @RequestParam(value = "name", required = false) String name,
                                     @RequestParam(value = "title", required = false) String title,
                                     @RequestParam(value = "categoryId", required = false) String categoryId,
                                     @RequestParam(value = "createdBy", required = false) String createdBy,
                                     @RequestParam(value = "sort", required = false) String sort) {
        return null;
    }

    @PostMapping("/add")
    public boolean createNotification(@RequestBody Notification notification) {
        return service.create(notification);
    }


    @RequestMapping(value = "/get-one/{id}")
    public Notification getOne(@PathVariable("id") Long id) {
        return service.getById(id);
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
