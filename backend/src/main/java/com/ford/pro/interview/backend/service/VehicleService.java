package com.ford.pro.interview.backend.service;

import com.ford.pro.interview.backend.repository.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

  private final VehicleRepository vehicleRepository;

  public VehicleService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }
}
