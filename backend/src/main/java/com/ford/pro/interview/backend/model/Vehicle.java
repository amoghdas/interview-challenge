package com.ford.pro.interview.backend.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder(toBuilder = true)
@JsonSerialize
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Vehicle {

  @Id
  @GeneratedValue(generator = "UUID")
  private UUID id;

  private String name;
  private String vin;
  private Boolean available;
}
