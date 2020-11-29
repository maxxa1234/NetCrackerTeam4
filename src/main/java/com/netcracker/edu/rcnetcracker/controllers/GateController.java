package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Gate;
import com.netcracker.edu.rcnetcracker.servicies.servicesImpl.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/gates")
@RestController
public class GateController {

    private GateService gateService;

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
