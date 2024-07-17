package com.example.loadbalancer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoadBalancerService {

    private RestTemplate restTemplate;

    private List<String> servers = new ArrayList<String>();

    private int serverSize;

    public LoadBalancerService(){
        restTemplate = new RestTemplate();
        servers.add("http://localhost:8081/");
        servers.add("http://localhost:8082/");
        servers.add("http://localhost:8083/");
        serverSize = 3;
    }

    public String loadBalanceService( int index ){
        int actualIndex = index % serverSize;

        String serverUrl = servers.get(actualIndex);

        String response = restTemplate.getForObject( serverUrl, String.class );

        System.out.println("The response is " + response );

        return response;
    }

}
