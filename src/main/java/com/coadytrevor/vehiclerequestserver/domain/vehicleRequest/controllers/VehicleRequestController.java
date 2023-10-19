package com.coadytrevor.vehiclerequestserver.domain.vehicleRequest.controllers;

import com.coadytrevor.vehiclerequestserver.domain.vehicleRequest.models.VehicleRequest;
import com.coadytrevor.vehiclerequestserver.domain.vehicleRequest.services.VehicleRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicle-request")
@CrossOrigin("*")
public class VehicleRequestController {
    private VehicleRequestService vehicleRequestService;

    @Autowired
    public VehicleRequestController(VehicleRequestService vehicleRequestService){
        this.vehicleRequestService = vehicleRequestService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleRequest>> getAll(){
        List<VehicleRequest> vehicleRequests = vehicleRequestService.getAll();
        return new ResponseEntity<>(vehicleRequests, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VehicleRequest> create(@RequestBody VehicleRequest vehicleRequest){
        vehicleRequest = vehicleRequestService.create(vehicleRequest);
        return new ResponseEntity<>(vehicleRequest, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<VehicleRequest> getById(@PathVariable("id")Long id){
        VehicleRequest vehicleRequest = vehicleRequestService.getById(id);
        return new ResponseEntity<>(vehicleRequest, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<VehicleRequest> getByEmail(@RequestParam String email){
        VehicleRequest vehicleRequest = vehicleRequestService.getByEmail(email);
        return new ResponseEntity<>(vehicleRequest, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<VehicleRequest> update(@PathVariable("id") Long id, @RequestBody VehicleRequest vehicleRequestDetail){
        vehicleRequestDetail = vehicleRequestService.update(id, vehicleRequestDetail);
        return new ResponseEntity<>(vehicleRequestDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        vehicleRequestService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}