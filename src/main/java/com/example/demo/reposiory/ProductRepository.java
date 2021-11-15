package com.example.demo.reposiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.product;

@Repository
public interface ProductRepository extends JpaRepository<product , Integer> {

}
