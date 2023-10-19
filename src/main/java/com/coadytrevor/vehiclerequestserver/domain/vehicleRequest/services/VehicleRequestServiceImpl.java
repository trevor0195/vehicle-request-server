package com.coadytrevor.vehiclerequestserver.domain.vehicleRequest.services;

import com.coadytrevor.vehiclerequestserver.domain.core.exceptions.ResourceCreationException;
import com.coadytrevor.vehiclerequestserver.domain.core.exceptions.ResourceNotFoundException;
import com.coadytrevor.vehiclerequestserver.domain.vehicleRequest.models.VehicleRequest;
import com.coadytrevor.vehiclerequestserver.domain.vehicleRequest.repos.VehicleRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleRequestServiceImpl implements VehicleRequestService{
    private VehicleRequestRepo vehicleRequestRepo;

    @Autowired
    public VehicleRequestServiceImpl(VehicleRequestRepo vehicleRequestRepo){
        this.vehicleRequestRepo = vehicleRequestRepo;
    }


    @Override
    public VehicleRequest create(VehicleRequest vehicleRequest) throws ResourceCreationException {
        Optional<VehicleRequest> optional = vehicleRequestRepo.findByEmail(vehicleRequest.getEmail());
        if (optional.isPresent())
            throw new ResourceCreationException("Customer with email exists: " + vehicleRequest.getEmail());
        vehicleRequest = vehicleRequestRepo.save(vehicleRequest);
        return vehicleRequest;
    }

    @Override
    public VehicleRequest getById(Long id) throws ResourceNotFoundException {
        VehicleRequest vehicleRequest = vehicleRequestRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nobody With the Id: " + id));
        return vehicleRequest;
    }

    @Override
    public VehicleRequest getByEmail(String email) throws ResourceNotFoundException {
        VehicleRequest vehicleRequest = vehicleRequestRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Nobody With the Email: " + email));
        return vehicleRequest;
    }

    @Override
    public List<VehicleRequest> getAll() {
        return vehicleRequestRepo.findAll();
    }

    @Override
    public VehicleRequest update(Long id, VehicleRequest vehicleRequestDetail) {
        VehicleRequest vehicleRequest = getById(id);
        vehicleRequest.setFirstName(vehicleRequestDetail.getFirstName());
        vehicleRequest.setLastName(vehicleRequestDetail.getLastName());
        vehicleRequest.setEmail(vehicleRequestDetail.getEmail());
        vehicleRequest.setVehicle(vehicleRequestDetail.getVehicle());
        vehicleRequest.setDescription(vehicleRequestDetail.getDescription());
        return vehicleRequest;
    }

    @Override
    public void delete(Long id) {
        VehicleRequest vehicleRequest = getById(id);
        vehicleRequestRepo.delete(vehicleRequest);
    }
}
