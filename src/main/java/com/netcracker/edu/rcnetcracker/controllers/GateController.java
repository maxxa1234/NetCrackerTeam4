package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Gate;
import com.netcracker.edu.rcnetcracker.model.Notification;
import com.netcracker.edu.rcnetcracker.model.User;
import com.netcracker.edu.rcnetcracker.servicies.filtering.EntitySpecification;
import com.netcracker.edu.rcnetcracker.servicies.filtering.SearchCriteria;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.EntityServiceImpl;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RequestMapping("/gates")
@RestController
public class GateController {

    private GateService gateService;
    private EntityServiceImpl<Gate> service;

    @GetMapping(value = "/filter",
            params = {"key", "operation", "value"})
    public List<Gate> getAllGatesFiltered(@RequestParam("key") String key, @RequestParam("operation") String operation, @RequestParam("value") User value) {
        return service.getFiltrated(new EntitySpecification<>(new SearchCriteria(key, operation, value)));
    }

    @Autowired
    public GateController(GateService gateService) {
        this.gateService = gateService;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public List<Gate>  test() {

        return gateService.receiveGates();
    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String  test1() {
        return "hi";
    }

    @RequestMapping(value ="/hello3" , method = RequestMethod.POST)
    public void addGate(@RequestBody Gate gate){
        gateService.createGate(gate);
    }


}
