package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Utility;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.UtilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("utilities")
@RestController
public class UtilitiesController {

    @Autowired
    private UtilitiesService service;

    @GetMapping(params = {"page", "size"})
    public Page<Utility> getAllUtilities(@RequestParam("page") int page, @RequestParam("size") int size){
        Page<Utility> resultPage = service.findPagination(page, size);
        if (page > resultPage.getTotalPages()) {
//            throw new ResourceNotFoundException();
        }
        return resultPage;
    }

    @GetMapping("{id}")
    public void getUtility(@PathVariable("id")Long utilityID){

    }

    @GetMapping("{date}")
    public void getUtilitiesFilteringDate(@PathVariable("date")Date date){

    }

    @PostMapping("/add")
    public void createUtility(){

    }

    @PostMapping(value = "/attachPhoto",
    params = {"utilityID", "photoURL"})
    public void attachPhoto(@RequestParam("utilityID")Long utilityID, @RequestParam("photoURL")String photoURL){

    }

}
