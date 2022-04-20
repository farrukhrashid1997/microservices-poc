package com.nagp.fac.api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagp.fac.api.common.AvailableProvider;
import com.nagp.fac.api.entity.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FacilityService {

    @Autowired
    private RestTemplate template;

    private Logger log = LoggerFactory.getLogger(FacilityService.class);

    public AvailableProvider assignProviderForService(int serviceId, String location) throws JsonProcessingException {
        AvailableProvider availableProvider = new AvailableProvider();
        if (verifyFacilityAvailable(serviceId)) {
            log.info("Request Provider for service after service is verified: {}", serviceId);
            availableProvider = template.postForObject("http://provider:9191/providers/get-provider", serviceId, AvailableProvider.class);
            log.info("Response of Provider service: {}", new ObjectMapper().writeValueAsString(availableProvider));
            availableProvider.setLocation(location);
            log.info("Notifying the provider with the details", new ObjectMapper().writeValueAsString(availableProvider));
            return availableProvider;
        }
        return availableProvider;
    }

    public boolean verifyFacilityAvailable(int serviceId) {
        log.info("Verifying service {}", serviceId);
        return getAllServices().stream().filter(s -> serviceId == s.getServiceId()).findFirst().isPresent();
    }


    protected List<Facility> getAllServices() {
        List<Facility> facilities = new ArrayList<>();
        facilities.add(new Facility(1, "Cleaning", 20));
        return facilities;
    }
}
