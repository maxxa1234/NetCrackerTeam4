package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Gate;
import com.netcracker.edu.rcnetcracker.servicies.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gates")
@RestController
public class GateController {

    private HelloService helloService;

    @Autowired
    public GateController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public Gate test() {
        return helloService.buildGate();
    }


}
