package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Notification;
import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.filtering.EntitySpecification;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RequestMapping("/notification")
@RestController
public class NotificationController {

    @Autowired
    private EntityServiceImpl<Notification> service;

    @GetMapping(params = {"size"})
    public List<Notification> getAllNotifications(@RequestParam("size") int size) {
        return service.findPagination(size);
    }

    @GetMapping(value = "/filter",
            params = {"key", "operation", "value"})
    public List<Notification> getAllNotificationsFiltered(@RequestParam("key") String key, @RequestParam("operation") String operation, @RequestParam("value") User value) {
        return service.getFiltrated(new EntitySpecification<>(new SearchCriteria(key, operation, value)));
    }

    @GetMapping("{date}")
    public void getUtilitiesNotificationDate(@PathVariable("date") Date date) {

    }

    @PostMapping("/utility/{utilityNotificationId}/{apartmentId}/{date}")
    public void postUtilityNotification(Utility utility, Long utilityNotificationId, Long apartmentId, Date date) {

    }

    @PostMapping("/routine/{entersId}")
    public void postRoutineNotification(Set<Long> entersId) {

    }

    @GetMapping("/routine/actual/{apartmentId}")
    public void getActualRoutineNotificationsByApartment(Long apartmentId) {

    }

    @GetMapping("/utility/actual/{apartmentId}")
    public void getActualUtilityNotificationsByApartment(Long apartmentId) {

    }

    @PostMapping("/setemail/{apartmentId}") //TODO do we have accounts for a livers?
    public void setEmailsForNotificationByApartmentId(Long apartmentId, Set<String> emails) {

    }

    @PutMapping("/setemail/{apartmentId}")
    public void updateEmailsForNotificationsByApartmentId(Long apartmentId, Set<String> emails) {

    }

    @PostMapping("/setdate/{apartmentId}/{date}")
    public void setDateOfUtilityNotificationByApartmentId(Long apartmentId, Date date) {

    }

    @PutMapping("/setdate/{apartmentId}/{date}")
    public void updateDateOfUtilityNotificationByApartmentId(Long apartmentId, Date date) {

    }
}
