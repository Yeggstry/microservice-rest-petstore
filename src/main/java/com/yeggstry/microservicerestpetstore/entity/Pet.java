package com.yeggstry.microservicerestpetstore.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "species" }) })
@Data
public class Pet {
	@Id
	@GeneratedValue
	private UUID id;

	@NotBlank
	@Size(max = 50)
	private String name;

	@NotNull
	@Enumerated(EnumType.STRING)
	private PetSpecies species;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private LocalDate dateOfBirth;
	
	@Size(max = 50)
	private String breed;
	
	@DecimalMin("0")
	private BigDecimal weight;
	@DecimalMin("0")
	private BigDecimal cost;
}
