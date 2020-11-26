package com.netcracker.edu.rcnetcracker.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("utilities")
@RestController
public class UtilitiesController {

    @GetMapping("{id}")
    public void getUtility(@PathVariable("id")Long utilityID){

    }

    @GetMapping("{date}")
    public void getUtilitiesFilteringDate(@PathVariable("date")Date date){

    }

    @PostMapping("/add/{utilityID}")
    public void createUtility(@PathVariable("utilityID")Long utilityID){

    }

    @PostMapping("/{utilityID}/{photoURL}")
    public void attachPhoto(@PathVariable("utilityID")Long utilityID, @PathVariable("photoURL")String photoURL){

    }

}
