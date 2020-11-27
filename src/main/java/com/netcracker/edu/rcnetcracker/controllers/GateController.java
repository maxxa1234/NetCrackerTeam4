package com.netcracker.edu.rcnetcracker.controllers;

import com.netcracker.edu.rcnetcracker.model.Gate;
import com.netcracker.edu.rcnetcracker.servicies.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{s}")
    public String getTest(@PathVariable String s){
        return s + " testGet";
    }

    @PostMapping("/{s}")
    public String postTest(@PathVariable String s){
        return s + " testPost";
    }

    @PutMapping("/{s}")
    public String putTest(@PathVariable String s){
        return s + " testPut";
    }

    @DeleteMapping("/{s}")
    public String deleteTest(@PathVariable String s){
        return s + " testDelete";
    }


}
