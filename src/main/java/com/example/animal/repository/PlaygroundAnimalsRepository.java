package com.example.animal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.animal.model.Animal;
import com.example.animal.model.Playground;
import com.example.animal.model.PlaygroundAnimals;

public interface PlaygroundAnimalsRepository extends JpaRepository<PlaygroundAnimals, Long> {
    public List<PlaygroundAnimals> findByPlayground(Playground playground);

    public List<PlaygroundAnimals> findByAnimal(Animal animal);
}
