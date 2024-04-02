package com.example.demo.service;

import com.example.demo.model.Carro;
import com.example.demo.model.Veiculo;

import java.util.List;

public interface VeiculoService <T extends Veiculo>{
    List<T> listar();

    T criar(T t);

    T atualizar(T t, long id);

    boolean deletar(long id);

    int quantidade();

    T listarPorId(Long id);

    List<T> listarPorMarca(String marca);

    List<T> listarPorPrecoMaior10K();
}
