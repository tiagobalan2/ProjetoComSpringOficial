package com.example.demo.repository;

import com.example.demo.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    // JpaRepository vai fazer com que os métodos find, findAll, save, delete e etc sejam herdados

    // Método para buscar carros por marca
    // Query me permite definir consultas personalizadas SQL nativo
    @Query("SELECT c FROM Carro c WHERE c.marca = ?1") // c é a entindade carro
    List<Carro> findByMarca(String marca);

    @Query("SELECT c FROM Carro c WHERE c.preco > :preco")
    List<Carro> findPrecoMaiorque(double preco);
}
