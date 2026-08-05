package com.ford.pro.interview.backend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.ford.pro.interview.backend.model.Vehicle;
import com.ford.pro.interview.backend.repository.VehicleRepository;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

  @Mock private VehicleRepository vehicleRepository;

  @InjectMocks private VehicleService vehicleService;

  @Test
  void getAllVehicles_returnsAllVehiclesFromRepository() {
    Vehicle lightning =
        Vehicle.builder()
            .id(UUID.randomUUID())
            .name("2024 Ford Lightning")
            .vin("1FTFW1E80MFA00001")
            .available(true)
            .build();
    Vehicle mustang =
        Vehicle.builder()
            .id(UUID.randomUUID())
            .name("2024 Ford Mustang")
            .vin("1FA6P8TH5L5100002")
            .available(false)
            .build();
    when(vehicleRepository.findAll()).thenReturn(List.of(lightning, mustang));

    List<Vehicle> vehicles = vehicleService.getAllVehicles();

    assertThat(vehicles).containsExactly(lightning, mustang);
  }

  @Test
  void getAllVehicles_returnsEmptyListWhenRepositoryIsEmpty() {
    when(vehicleRepository.findAll()).thenReturn(List.of());

    List<Vehicle> vehicles = vehicleService.getAllVehicles();

    assertThat(vehicles).isEmpty();
  }
}
