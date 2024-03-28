package com.example.demo.repository;

import com.example.demo.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    // Método para buscar carros por marca
    // Query me permite definir consultas personalizadas SQL nativo
    @Query("SELECT c FROM Carro c WHERE c.marca = ?1") // c é a entindade carro
    List<Carro> findByMarca(String marca);
}
