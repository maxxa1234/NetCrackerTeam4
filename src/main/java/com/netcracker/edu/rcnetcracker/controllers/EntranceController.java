package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Entrance;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.EntranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/entrance")
@RestController
public class EntranceController {

    @Autowired
    private EntranceService service;

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

    @GetMapping(params = {"page", "size"})
    public Page<Entrance> getAllEntrances(@RequestParam("page") int page, @RequestParam("size") int size) {
        Page<Entrance> resultPage = service.findPagination(page, size);
        if (page > resultPage.getTotalPages()) {
//            throw new ResourceNotFoundException();
        }
        return resultPage;
    }

    @GetMapping("/log")
    public void getLog() {

    }
}
