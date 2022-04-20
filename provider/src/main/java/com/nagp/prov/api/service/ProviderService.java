package com.nagp.prov.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagp.prov.api.entity.Provider;
import org.slf4j.Logger;
import java.util.UUID;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ProviderService {

    private Logger log = LoggerFactory.getLogger(ProviderService.class);

    public Provider getServiceProviders(int serviceId) throws JsonProcessingException {
        log.info("Request providers from provider service: {}", serviceId);
        List<Provider> providers = getAllProviders();
        List<Provider> providersForService = getAllProviders().stream()
                .filter(p -> serviceId == p.getServiceProvidedID()).collect(Collectors.toList());
        log.info("Response with all the available providers for service : {}", new ObjectMapper().writeValueAsString(providersForService));
        return notifyAndAssignProvider(providersForService);
    }

    //this function is to notify the provider and assign the provider who accepts the request
    public Provider notifyAndAssignProvider(List<Provider> providers) throws JsonProcessingException {
        Random rand = new Random();
        Provider assignedProv = providers.get(rand.nextInt(providers.size()));
        log.info("Notifying and assigning provider", new ObjectMapper().writeValueAsString(assignedProv));
        String bookingId = getBookingId();
        log.info("Generating a booking ID", bookingId);

        assignedProv.setBookingId(bookingId);
        return assignedProv;
    }

    public String getBookingId(){
        UUID uuid=UUID.randomUUID();
        return uuid.toString();
    }

    protected List<Provider> getAllProviders() {
        List<Provider> providers = new ArrayList<>();
        providers.add(new Provider(11, "John", 1));
        providers.add(new Provider(12, "Doe", 2));
        providers.add(new Provider(13, "Waze", 3));
        providers.add(new Provider(14, "Wayne", 1));
        providers.add(new Provider(15, "Smith", 2));
        providers.add(new Provider(16, "Stuart", 3));
        providers.add(new Provider(17, "Tom", 1));
        providers.add(new Provider(18, "Thomas", 1));
        providers.add(new Provider(19, "Tim", 1));
        return providers;
    }
}
