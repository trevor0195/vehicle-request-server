package com.coadytrevor.vehiclerequestserver.domain.vehicleRequest.services;

import com.coadytrevor.vehiclerequestserver.domain.core.exceptions.ResourceCreationException;
import com.coadytrevor.vehiclerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.coadytrevor.vehiclerequestserver.domain.vehicleRequest.models.VehicleRequest;

import java.util.List;

public interface VehicleRequestService {

    VehicleRequest create(VehicleRequest vehicleRequest) throws ResourceCreationException;

    VehicleRequest getById(Long id) throws ResourceNotFoundException;

    VehicleRequest getByEmail(String email) throws  ResourceNotFoundException;

    List<VehicleRequest> getAll();

    VehicleRequest update(Long id, VehicleRequest vehicleRequestDetail);

    void delete(Long id);
}
