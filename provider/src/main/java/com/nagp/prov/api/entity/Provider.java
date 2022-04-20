package com.nagp.prov.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Provider {
    private int providerId;
    private String providerName;
    private int serviceProvidedID;
    private String bookingId;

    public Provider (int providerId, String providerName,int serviceProvidedId){
        this.providerId = providerId;
        this.serviceProvidedID = serviceProvidedId;
        this.providerName = providerName;
    }

}
