package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Notification;
import com.netcracker.edu.rcnetcracker.servicies.MailSenderService;
import com.netcracker.edu.rcnetcracker.servicies.NotificationService;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RequestMapping("notification")
@RestController
public class NotificationController {
    private final NotificationService service;
    private final MailSenderService mailSenderService;

    @Value("${server.port}")
    String serverPortName;

    @Autowired
    public NotificationController(NotificationService service, MailSenderService mailSenderService) {
        this.service = service;
        this.mailSenderService = mailSenderService;
    }

    @GetMapping
    public Page<Notification> getAll(@RequestParam(value = "page", required = false) Integer page,
                                     @RequestParam(value = "size", required = false) Integer size,
                                     @RequestParam(value = "text", required = false) String text,
                                     @RequestParam(value = "date", required = false) Long date,
                                     @RequestParam(value = "name", required = false) String name,
                                     @RequestParam(value = "title", required = false) String title,
                                     @RequestParam(value = "categoryId", required = false) String categoryId,
                                     @RequestParam(value = "createdBy", required = false) String createdBy,
                                     @RequestParam(value = "sort", required = false) String sort) {

        List<SearchCriteria> filters = new ArrayList<>();
        Pageable pageable = null;
        if (page == null && size != null) {
            pageable = PageRequest.of(0, size);
        }
        if (page != null && size != null) {
            pageable = PageRequest.of(page, size);
        }
        if (date != null) {
            //TODO: добить фильтр по датам
            filters.add(new SearchCriteria("date", getMonthAndYear(new Date(date))));
        }
        if (name != null) {
            filters.add(new SearchCriteria("name", "like '%" + name + "%' "));
        }
        Page<Notification> page1 = service.getAll(pageable, filters, new SortCriteria(sort));

        return page1;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteNotification(@PathVariable("id") Long id) {
        return service.delete(id);
    }

    @PostMapping("/add")
    public boolean createNotification(@RequestBody Notification notification) {
        //TODO: сделать отправку уведомления по email

        service.create(notification);
        List<String> emails = service.getAllEmails();
        emails.add("victormorgish@gmail.com");
        for (String email: emails) {
            mailSenderService.sendEmail(email, notification.getTitle(), notification.getText());
        }
        return true;
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

    private String getMonthAndYear(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
