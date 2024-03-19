package com.example.demo.service;

import com.example.demo.model.Bicicleta;
import com.example.demo.repository.BicicletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BicicletaService implements VeiculoService<Bicicleta> {

    @Autowired
    BicicletaRepository bicicletaRepository;
    @Override
    public List<Bicicleta> listar() {
        return bicicletaRepository.findAll();
    }

    @Override
    public Bicicleta criar(Bicicleta bicicleta) {
        return bicicletaRepository.save(bicicleta);
    }

    @Override
    public Bicicleta atualizar(Bicicleta bicicleta, long idBicicleta) {
        // verifica se o id é valido
        if (bicicletaRepository.existsById(idBicicleta)) {
            bicicleta.setIdBicicleta(idBicicleta);
            return bicicletaRepository.save(bicicleta);
        }
        return null;
    }

    @Override
    public boolean deletar(long idBicicleta) {
        // verifica se o id é valido
        if (bicicletaRepository.existsById(idBicicleta)) {
            bicicletaRepository.deleteById(idBicicleta);
            return true;
        }
        return false;
    }

    @Override
    public int quantidade() {
        return bicicletaRepository.findAll().size();
    }

    @Override
    public Bicicleta listarPorId(Long idBicicleta) {
        // verifica se o id é valido
        if (bicicletaRepository.existsById(idBicicleta)) {
            return bicicletaRepository.findById(idBicicleta).orElse(null);
        }
        return null;
    }
}
