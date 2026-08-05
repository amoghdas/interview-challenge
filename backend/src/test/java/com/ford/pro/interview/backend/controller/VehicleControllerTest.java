package com.ford.pro.interview.backend.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ford.pro.interview.backend.config.SecurityConfig;
import com.ford.pro.interview.backend.model.Vehicle;
import com.ford.pro.interview.backend.service.VehicleService;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(VehicleController.class)
@Import(SecurityConfig.class)
class VehicleControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockitoBean private VehicleService vehicleService;

  @Test
  void getAllVehicles_returnsAllVehiclesAsJson() throws Exception {
    Vehicle lightning =
        Vehicle.builder()
            .id(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"))
            .name("2024 Ford Lightning")
            .vin("1FTFW1E80MFA00001")
            .available(true)
            .build();
    when(vehicleService.getAllVehicles()).thenReturn(List.of(lightning));

    mockMvc
        .perform(get("/api/fleet/vehicles"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$[0].id").value("550e8400-e29b-41d4-a716-446655440001"))
        .andExpect(jsonPath("$[0].name").value("2024 Ford Lightning"))
        .andExpect(jsonPath("$[0].vin").value("1FTFW1E80MFA00001"))
        .andExpect(jsonPath("$[0].available").value(true));
  }

  @Test
  void getAllVehicles_returnsEmptyArrayWhenNoVehicles() throws Exception {
    when(vehicleService.getAllVehicles()).thenReturn(List.of());

    mockMvc
        .perform(get("/api/fleet/vehicles"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$").isEmpty());
  }
}
