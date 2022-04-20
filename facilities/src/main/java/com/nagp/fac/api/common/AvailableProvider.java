package com.nagp.fac.api.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableProvider {
    private int providerId;
    private String providerName;
    private int serviceProvidedId;
    private String location;
    private String bookingId;
}
