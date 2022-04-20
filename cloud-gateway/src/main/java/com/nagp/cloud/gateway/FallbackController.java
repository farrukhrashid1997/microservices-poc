package com.nagp.cloud.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
    @RequestMapping("/provider-fallback")
    public Mono<String> providerServiceFallback(){
        return Mono.just("Provider service is taking too long to respond or is down. Please try again later");
    }
    @RequestMapping("/facility-fallback")
    public Mono<String> facilityServiceFallback(){
        return Mono.just("Facility service is taking too long to respond or is down. Please try again later");
    }
}
