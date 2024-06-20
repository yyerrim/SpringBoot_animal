package com.example.animal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.animal.model.Warranty;

public interface WarrantyRepository extends JpaRepository<Warranty, Long> {
    public Warranty findByModelNm(String modelNm);
}
