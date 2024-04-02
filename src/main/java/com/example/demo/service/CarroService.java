package com.example.demo.service;

import com.example.demo.model.Carro;
import com.example.demo.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService implements VeiculoService<Carro> {

    @Autowired
    CarroRepository carroRepository;

    @Override
    public List<Carro> listar() {
        return carroRepository.findAll();
    }

    @Override
    public Carro criar(Carro carro) {
        return carroRepository.save(carro);
    }

    @Override
    public Carro atualizar(Carro carro, long idCarro) {
    //verificar se o id é valido
        if(carroRepository.existsById(idCarro)) {
            //atualizar o objeto na base
            carro.setIdCarro(idCarro);
            return carroRepository.save(carro);
        }
        return null;
        // não realiza nenhuma alteração
    }

    @Override
    public boolean deletar(long idCarro) {
        if(carroRepository.existsById(idCarro)) {
            carroRepository.deleteById(idCarro);
            return true;
        }
        return false;
    }

    @Override
    public int quantidade() {
        return carroRepository.findAll().size();
    }

    @Override
    public Carro listarPorId(Long idCarro) {
        //verificar se o id é valido
        if (carroRepository.existsById(idCarro)) {
            //retornar o carro
            return carroRepository.findById(idCarro).orElse(null);
        }
        return null;
    }

    @Override
    public List<Carro> listarPorMarca(String marca) {
        return (carroRepository.findByMarca(marca));
    }

    @Override
    public List<Carro> listarPorPrecoMaior10K() {
        return carroRepository.findPrecoMaiorque(10000.00);
    }





}
