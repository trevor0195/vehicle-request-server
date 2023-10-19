package com.coadytrevor.vehiclerequestserver.domain.vehicleRequest.repos;

import com.coadytrevor.vehiclerequestserver.domain.vehicleRequest.models.VehicleRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRequestRepo extends JpaRepository<VehicleRequest, Long> {
    Optional<VehicleRequest> findByEmail(String email);

}
