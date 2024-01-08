package com.cloud.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
    @GetMapping("/clientServiceFallback")
    public String clientServiceFallBackMethod(){
        return "Client Service is taking longer than expected";
    };
    @GetMapping("/transferServiceFallback")
    public String transferServiceFallBackMethod(){
        return "Transfer Service is taking longer than expected";
    };
    @GetMapping("/backofficeServiceFallback")
    public String backofficeServiceFallBackMethod(){
        return "BackOffice Service is taking longer than expected";
    };
    @GetMapping("/agentServiceFallback")
    public String agentServiceFallBackMethod(){
        return "Agent Service is taking longer than expected";
    };


}
