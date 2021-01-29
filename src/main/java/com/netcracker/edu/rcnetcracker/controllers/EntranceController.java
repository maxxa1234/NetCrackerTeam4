package com.netcracker.edu.rcnetcracker.controllers;

import com.lowagie.text.DocumentException;
import com.netcracker.edu.rcnetcracker.db.access.OracleDbAccess;
import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.model.Logger;
import com.netcracker.edu.rcnetcracker.servicies.EntranceService;
import com.netcracker.edu.rcnetcracker.servicies.ExportPDFService;
import com.netcracker.edu.rcnetcracker.servicies.LoggerService;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.requestBuilder.criteria.SortCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Если запрос подразумевает фильтр, то строковые переменные типа имени надо привети к виду "like '%"+name+"%'" иначе не сработает
 * Фильтры записываются в список, не смотря на их количество и передаются дальше
 * Указывать несколько критериев сортировки нельзя
 */

@RequestMapping("/entrance")
@RestController
public class EntranceController {

    private final EntranceService service;
    private final LoggerService loggerService;
    private final LoggerController loggerController;

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EntranceController.class.getName());

    public EntranceController(EntranceService service, LoggerService loggerService, LoggerController loggerController) {
        this.service = service;
        this.loggerService = loggerService;
        this.loggerController = loggerController;
    }

    @Autowired
    private OracleDbAccess oracleDbAccess;

    @GetMapping(value = "/open",
            params = {"key_id", "entrance_id"})
    public boolean openGate(@RequestParam("key_id") Long key_id, @RequestParam("entrance_id") Long entrance_id) {
        //will return isOpened
        return false;
    }

    @GetMapping(value = "/block",
            params = {"key_id", "entrance_id"})
    public boolean blockGate(@RequestParam("key_id") Long key_id, @RequestParam("entrance_id") Long entrance_id) {
        //will return isBlock
        return false;
    }

    @PostMapping("/add")
    public boolean createEntrance(@RequestBody Entrance entrance) {
        return service.create(entrance);
    }

    @DeleteMapping(params = {"id"})
    public boolean deleteEntrance(@RequestParam("id") Long entranceId) {
        return service.delete(entranceId);
    }

    @PutMapping
    public boolean updateEntrance(@RequestBody Entrance object) {
        return service.update(object);
    }

    @GetMapping
    public Page<Entrance> getAll(@RequestParam(value = "page", required = false) Integer page,
                                 @RequestParam(value = "size", required = false) Integer size,
                                 @RequestParam(value = "typeId", required = false) String typeId,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "buildingId", required = false) String buildingId,
                                 @RequestParam(value = "isActive", required = false) String isActive,
                                 @RequestParam(value = "status", required = false) String status,
                                 @RequestParam(value = "sort", required = false) String sort) {
        List<SearchCriteria> filters = new ArrayList<>();
        Pageable pageable = null;
        if (page == null && size != null) {
            pageable = PageRequest.of(0, size);
        }
        if (page != null && size != null) {
            pageable = PageRequest.of(page, size);
        }
        if (typeId != null) {
            filters.add(new SearchCriteria("typeId", typeId));
        }
        if (name != null) {
            filters.add(new SearchCriteria("name", "like '%" + name + "%' "));
        }
        if (buildingId != null) {
            filters.add(new SearchCriteria("buildingId", "like '%" + buildingId + "%' "));
        }
        if (isActive != null) {
            filters.add(new SearchCriteria("isActive", "like '%" + isActive + "%' "));
        }
        if (status != null) {
            filters.add(new SearchCriteria("status", "like '%" + status + "%' "));
        }
        Page<Entrance> page1 = service.getAll(pageable, filters, new SortCriteria(sort));
        return page1;
    }

    @GetMapping("/log")
    public void getLog(@RequestParam("page") int page, @RequestParam("size") int size,
                       @RequestParam(value = "filter", required = false) String filter,
                       @RequestParam(value = "sort", required = false) String sort) {

    }

    @RequestMapping(value = "/get-one/{id}")
    public Entrance getOne(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @GetMapping("/export")
    public void exportToPDF(HttpServletResponse response,
                            @RequestParam(value = "dateFrom", required = false) Long dateFrom,
                            @RequestParam(value = "dateTo", required = false) Long dateTo) throws DocumentException, IOException {

        List<SearchCriteria> filters = new ArrayList<>();
        if (dateFrom != null) {
            filters.add(new SearchCriteria("date", " > to_date('" + changeDateFormat(new Date(dateFrom))
                    + "', 'yyyy-mm-dd hh24:mi:ss')"));
        }
        if (dateTo != null) {
            filters.add(new SearchCriteria("date", " < to_date('" + changeDateFormat(new Date(dateTo))
                    + "', 'yyyy-mm-dd hh24:mi:ss')"));
        }
        response.setContentType("application/pdf");

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename = entrance_" + currentDateTime + ".pdf";

        response.setHeader(headerKey,headerValue);

        SortCriteria sortCriteria = new SortCriteria("isActive:DESC");
        Page<Logger> pageEntrance = loggerService.getAll(null,filters,null); //TODO:Передать правильный фильтр
        List<Logger> loggerList = pageEntrance.getContent();

        ExportPDFService exporter = new ExportPDFService(loggerList);
        exporter.export(response);
    }

    private String changeDateFormat(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
