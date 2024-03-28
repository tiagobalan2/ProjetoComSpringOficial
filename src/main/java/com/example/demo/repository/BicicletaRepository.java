package com.example.demo.repository;

import com.example.demo.model.Bicicleta;
import com.example.demo.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {
    // Método para buscar carros por marca
    // Query me permite definir consultas personalizadas SQL nativo
    @Query("SELECT b FROM Carro b WHERE b.marca = ?1") // b é a entindade bicicleta
    List<Bicicleta> findByMarca(String marca);
}
