package com.example.loadbalancer.controller;


import com.example.loadbalancer.service.LoadBalancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadBalancerController {

    @Autowired
    private LoadBalancerService service;

    int counter = 0;

    @GetMapping("/Test")
    public String testLoadBalanceHealth(){
        System.out.println("Entered into testLoadBalanceHealth() ");

        return "The testLoadBalanceHealth service is healthy";
    }

    @GetMapping("/loadBalance")
    public String performLoadBalance(){
        System.out.println("Entered into performLoadBalance() ");
        String serviceResponse = service.loadBalanceService(counter);

        if( serviceResponse != null ){
            System.out.println("The Service Call is a success");
            counter++;
        }

        System.out.println("Exited from performLoadBalance() ");

        return serviceResponse;
    }
}
