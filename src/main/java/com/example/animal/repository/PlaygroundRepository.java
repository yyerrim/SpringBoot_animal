package com.example.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.animal.model.Playground;

public interface PlaygroundRepository extends JpaRepository<Playground, Long> {
    public Playground findByAddress(String address);
}
