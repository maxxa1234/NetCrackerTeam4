package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/entrance")
@RestController
public class EntranceController {

    @Autowired
    private EntityServiceImpl<Entrance> service;

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
    public void createEntrance(@RequestBody Entrance entrance) {

    }

    @DeleteMapping("{id}")
    public void deleteEntrance(@PathVariable("id") Entrance entrance) {

    }

    @PutMapping("{id}")
    public void updateEntrance(@PathVariable("id") Entrance entrance, @RequestBody Entrance updatingEntrance) {

    }

    @GetMapping(params = {"size"})
    public List<Entrance> getAllEntrances(@RequestParam("size") int size) {
        return service.findPagination(size);
    }

    @GetMapping("/log")
    public void getLog() {

    }
}
