package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Entrance;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/entrance")
@RestController
public class EntranceController {

    @GetMapping("/open/{key_id}/{entrance_id}")
    public void openGate(@PathVariable("key_id") Long key_id, @PathVariable("entrance_id") Long entrance_id){

    }

    @GetMapping("/lock/{key_id}/{entrance_id}")
    public void blockGate(@PathVariable("key_id") Long key_id, @PathVariable("entrance_id") Long entrance_id){

    }

    @PostMapping("/add")
    public void createEntrance(@RequestBody Entrance entrance){

    }

    @DeleteMapping("{id}")
    public void deleteEntrance(@PathVariable("id")Entrance entrance){

    }

    @PutMapping("{id}")
    public void updateEntrance(@PathVariable("id")Entrance entrance, @RequestBody Entrance updatingEntrance){

    }

    @GetMapping
    public void getAllEntrances(){

    }

    @GetMapping("/log")
    public void getLog(){

    }
}
