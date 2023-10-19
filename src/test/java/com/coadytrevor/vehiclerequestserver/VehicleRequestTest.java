package com.coadytrevor.vehiclerequestserver;

import com.coadytrevor.vehiclerequestserver.domain.vehicleRequest.models.VehicleRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class VehicleRequestTest {
    @Test
    public void constructorTest01(){
        Date date = new Date();
        VehicleRequest request = new VehicleRequest("Trevor", "Coady", "trevor0195@gmail.com", "1967 Ford Mustang", "I want a Mustang", "10/15/2023");
        request.setId(1L);

        String expected = "Trevor Coady trevor0195@gmail.com 1967 Ford Mustang I want a Mustang 10/15/2023";
        String actual = request.toString();

        Assertions.assertEquals(expected, actual);
    }
}
