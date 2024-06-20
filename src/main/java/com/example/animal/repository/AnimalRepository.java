package com.example.animal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.animal.model.Animal;
import com.example.animal.model.Owner;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    public Animal findByName(String name);

    public List<Animal> findByOwner(Owner owner);
}
