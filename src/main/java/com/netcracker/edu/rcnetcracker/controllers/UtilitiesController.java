package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.UtilitiesService;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
                                @RequestParam(value = "dateFrom", required = false) Long dateFrom,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "dateTo", required = false) Long dateTo,
                                @RequestParam(value = "date", required = false) Long date,
                                @RequestParam(value = "currentMonthReading", required = false) String currentMonthReading,
                                @RequestParam(value = "lastMonthReading", required = false) String lastMonthReading,
                                @RequestParam(value = "status", required = false) String status,
                                @RequestParam(value = "service", required = false) String serviceID,
                                @RequestParam(value = "sort", required = false) String sort) {
        List<SearchCriteria> filters = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
            filters.add(new SearchCriteria("date", " > to_date('"+dateFormat.format(new Date(dateFrom))
                    +"', 'yyyy-mm-dd hh24:mi:ss')"));
        }
        if (dateTo != null) {
            filters.add(new SearchCriteria("date", " < to_date('"+dateFormat.format(new Date(dateFrom))
                    +"', 'yyyy-mm-dd hh24:mi:ss')"));
        }
        if (date != null) {
            filters.add(new SearchCriteria("month", getMonthAndYear(new Date(date))));
        }
        if (name != null) {
            filters.add(new SearchCriteria("name", "like '%" + name + "%' "));
        }
        if (currentMonthReading != null) {
            filters.add(new SearchCriteria("currentMonthReading", "like '%" + currentMonthReading + "%' "));
        }
        if (currentMonthReading != null) {
            filters.add(new SearchCriteria("lastMonthReading", "like '%" + lastMonthReading + "%' "));
        }
        if (status != null) {
            filters.add(new SearchCriteria("status", "like '%" + status + "%' "));
        }
        if (serviceID != null) {
            filters.add(new SearchCriteria("service", serviceID));
        }
        return service.getAll(pageable, filters, new SortCriteria(sort));
    }

    @GetMapping("{id}")
    public Utility getUtility(@PathVariable("id") Long utilityID) {
        return service.getById(utilityID);
    }

    @PostMapping("/add")
    public boolean createUtility(@RequestBody Utility utility) {
        return service.create(utility);
    }

    @PutMapping
    public boolean updateUtility(@RequestBody Utility utility) {
        if (utility.getEndMonthReading() == null || utility.getStartMonthReading() == null) {
            Utility utilityFromDB = service.getById(utility.getId());
            if (utility.getEndMonthReading() != null) {
                if (utility.getEndMonthReading() > utilityFromDB.getStartMonthReading()) {
                    utility.setAmountToPay(
                            (utility.getEndMonthReading() - utility.getStartMonthReading())
                                    * utility.getService().getTariff()
                    );
                    utility.setStatus(true);
                    /**
                     * Создание новой записи, при условии, что происходит внесение новых записей
                     * */
                    Utility newUtility = new Utility();
                    newUtility.setDate(monthIncrement(utility.getDate()));
                    newUtility.setStartMonthReading(utility.getEndMonthReading());
                    newUtility.setService(utility.getService());
                    newUtility.setStatus(false);
                    service.create(newUtility);

                }
            }
        }

        return service.update(utility);
    }

    private Date monthIncrement(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    private String getMonthAndYear(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy MM");
        return dateFormat.format(date);
    }

}
