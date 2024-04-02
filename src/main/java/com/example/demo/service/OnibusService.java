package com.example.demo.service;

import com.example.demo.model.Bicicleta;
import com.example.demo.model.Onibus;
import com.example.demo.model.Veiculo;
import com.example.demo.repository.OnibusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OnibusService implements VeiculoService<Onibus>{
    @Autowired
    OnibusRepository onibusRepository;

    @Override
    public List listar() {
        return onibusRepository.findAll();
    }

    @Override
    public Onibus criar(Onibus onibus) {
        return onibusRepository.save(onibus);
    }


    @Override
    public Onibus atualizar(Onibus onibus, long idOnibus) {
        //verificar se o id é valido
        if (onibusRepository.existsById(idOnibus)) {
            // atualizar o objeto na base
            onibus.setIdOnibus((idOnibus));
            return onibusRepository.save(onibus);
        }
        return null;
        // não realiza nenhuma alteração
    }


    @Override
    public boolean deletar(long idOnibus) {
        // verificar se o id é valido
        if (onibusRepository.existsById(idOnibus)) {
            onibusRepository.deleteById(idOnibus);
            return true;
        }
        return false;
    }

    @Override
    public int quantidade() {
        return onibusRepository.findAll().size();
    }

    @Override
    public Onibus listarPorId(Long idOnibus) {
        // verificar se oi é valido
        if (onibusRepository.existsById(idOnibus)) {
            // retornar o onibus
            return onibusRepository.findById(idOnibus).orElse(null);
        }
        return null;
    }

    @Override
    public List<Onibus> listarPorMarca(String marca) {
        return (onibusRepository.findByMarca(marca));
    }

    @Override
    public List<Onibus> listarPorPrecoMaior10K() {
        return onibusRepository.findPrecoMaiorque(10000.00);
    }

}
