package com.nagp.fac.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nagp.fac.api.entity.Facility;
import com.nagp.fac.api.services.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    FacilityService facilityService;

    @PostMapping("/get-facility-provider")
    public Object getFacilityProvider(@RequestBody Facility facility) throws JsonProcessingException {
        return facilityService.assignProviderForService(facility.getServiceId(), facility.getLocation());
    }
}
