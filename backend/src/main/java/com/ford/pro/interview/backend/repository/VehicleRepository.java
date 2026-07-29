package com.ford.pro.interview.backend.repository;

import com.ford.pro.interview.backend.model.Vehicle;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The database table is automatically created to match the Vehicle.java object with a column for
 * each of its properties.
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {
  /**
   * JPA automatically creates a save function under the covers. You can call
   * vehicleRepository.save(vehicle) and the signature looks as follows:
   *
   * <p>public Vehicle save(Vehicle vehicle) {...}
   */
}
