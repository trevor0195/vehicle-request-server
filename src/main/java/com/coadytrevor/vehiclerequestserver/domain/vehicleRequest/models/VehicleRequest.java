package com.coadytrevor.vehiclerequestserver.domain.vehicleRequest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity // For JPA to save to database
@NoArgsConstructor // Generate our non argument constructor
@RequiredArgsConstructor
@Data // Generate our getters and setters

public class VehicleRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;

    @NonNull
    private String vehicle;

    @NonNull
    private String description;

    @NonNull
    private String createAt;

    public String toString(){
        return String.format("%d %s %s %s %s %s %s",id, firstName, lastName, email, vehicle, description, createAt);
    }

}
