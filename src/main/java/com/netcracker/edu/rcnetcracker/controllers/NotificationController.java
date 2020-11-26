package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Utility;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@RequestMapping("/notification")
@RestController
public class NotificationController {

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
