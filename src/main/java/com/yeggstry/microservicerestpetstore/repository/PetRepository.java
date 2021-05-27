package com.yeggstry.microservicerestpetstore.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yeggstry.microservicerestpetstore.entity.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, UUID> {
}
