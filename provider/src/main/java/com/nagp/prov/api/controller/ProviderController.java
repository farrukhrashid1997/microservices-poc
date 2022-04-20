package com.nagp.prov.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nagp.prov.api.entity.Provider;
import com.nagp.prov.api.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService service;

    @PostMapping("/get-provider")
    public Provider getProviderForService(@RequestBody int serviceId) throws JsonProcessingException {
        return service.getServiceProviders(serviceId);
    }
}
