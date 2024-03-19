package com.example.demo.repository;

import com.example.demo.model.Carro;
import com.example.demo.model.Onibus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnibusRepository extends JpaRepository<Onibus, Long> {

}
