package com.ford.pro.interview.backend;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class VehicleControllerIntegrationTest {

  @Autowired private MockMvc mockMvc;

  @Test
  void getAllVehicles_returnsSeededFleet() throws Exception {
    mockMvc
        .perform(get("/api/fleet/vehicles"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isArray())
        .andExpect(jsonPath("$.length()").value(3))
        .andExpect(jsonPath("$[0].name").value("2024 Ford Lightning"))
        .andExpect(jsonPath("$[0].vin").value("1FTFW1E80MFA00001"))
        .andExpect(jsonPath("$[0].available").value(true))
        .andExpect(jsonPath("$[1].name").value("2024 Ford Mustang"))
        .andExpect(jsonPath("$[1].vin").value("1FA6P8TH5L5100002"))
        .andExpect(jsonPath("$[1].available").value(false))
        .andExpect(jsonPath("$[2].name").value("2024 Ford Transit"))
        .andExpect(jsonPath("$[2].vin").value("1FTBW2CM0MKA00003"))
        .andExpect(jsonPath("$[2].available").value(true));
  }
}
