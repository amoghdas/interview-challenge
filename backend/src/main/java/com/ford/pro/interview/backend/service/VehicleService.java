package com.ford.pro.interview.backend.service;

import com.ford.pro.interview.backend.model.Vehicle;
import com.ford.pro.interview.backend.repository.VehicleRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

  private final VehicleRepository vehicleRepository;

  public VehicleService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  public List<Vehicle> getAllVehicles() {
    return vehicleRepository.findAll();
  }
}
