package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Notification;
import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@RequestMapping("/notification")
@RestController
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @GetMapping(params = {"page", "size"})
    public Page<Notification> getAllNotifications(@RequestParam("page") int page, @RequestParam("size") int size){
        Page<Notification> resultPage = notificationService.findPagination(page, size);
        if (page > resultPage.getTotalPages()) {
//            throw new ResourceNotFoundException();
        }
        return resultPage;
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
