package com.netcracker.edu.rcnetcracker.servicies;

import com.netcracker.edu.rcnetcracker.model.Gate;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getHello() {
        return "hello2";
    }

    public Gate buildGate() {
        Gate gate = new Gate();
        gate.setId(1l);
        gate.setName("IamGate");
        gate.setDescription("Our test gate");
        return gate;
    }

}
