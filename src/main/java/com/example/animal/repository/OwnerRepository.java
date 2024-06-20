package com.example.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.animal.model.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    public Owner findByName(String name);
}
