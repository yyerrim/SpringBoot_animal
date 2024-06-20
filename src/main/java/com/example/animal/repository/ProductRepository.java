package com.example.animal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.animal.model.Animal;
import com.example.animal.model.Product;
import com.example.animal.model.Warranty;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByName(String name);

    public List<Product> findByAnimal(Animal animal);

    public List<Product> findByWarranty(Warranty warranty);
}
