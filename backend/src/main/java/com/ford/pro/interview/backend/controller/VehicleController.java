package com.ford.pro.interview.backend.controller;

import com.ford.pro.interview.backend.model.Vehicle;
import com.ford.pro.interview.backend.service.VehicleService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fleet")
public class VehicleController {

  private final VehicleService vehicleService;

  public VehicleController(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  @GetMapping("/vehicles")
  public List<Vehicle> getAllVehicles() {
    return vehicleService.getAllVehicles();
  }
}
