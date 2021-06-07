package com.yeggstry.microservicerestpetstore.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yeggstry.microservicerestpetstore.entity.Pet;
import com.yeggstry.microservicerestpetstore.exception.PetNotFoundException;
import com.yeggstry.microservicerestpetstore.repository.PetRepository;

@RestController
@RequestMapping("/petstore/api/pets")
public class PetsController {
	@Autowired
	private PetRepository repository;

	@GetMapping("/")
	public Iterable<Pet> findPets() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Pet findById(@PathVariable String id) {
		return repository.findById(UUID.fromString(id))
				.orElseThrow(() -> new PetNotFoundException(String.format("Unable to find pet by ID %s", id)));
	}

	@PostMapping("/")
	public Pet createNewPet(@Valid @RequestBody final Pet pet) {
		return repository.save(pet);
	}

	@PutMapping("/{id}")
	public Pet updatePet(@PathVariable("id") String id, @Valid @RequestBody final Pet pet) {
		UUID uuid = UUID.fromString(id);
		repository.findById(uuid).orElseThrow(
				() -> new PetNotFoundException(String.format("Unable to find pet by ID %s for updating", id)));
		// the pet already exists in the database, so update - set the id in the pet
		// just in case
		pet.setId(uuid);
		return repository.save(pet);
	}
}
