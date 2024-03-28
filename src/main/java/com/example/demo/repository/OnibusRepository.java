package com.example.demo.repository;

import com.example.demo.model.Carro;
import com.example.demo.model.Onibus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OnibusRepository extends JpaRepository<Onibus, Long> {
    // Método para buscar carros por marca
    // Query me permite definir consultas personalizadas SQL nativo
    @Query("SELECT o FROM Onibus o WHERE o.marca = ?1") // o é a entindade onibus
    List<Onibus> findByMarca(String marca);
}
