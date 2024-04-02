package com.example.demo.controller;

import com.example.demo.model.Carro;
import com.example.demo.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    CarroService carroService;
    @GetMapping
    // GET
    public List<Carro> listarCarros() {
        return carroService.listar();
    }

    @GetMapping("/{idCarro}")
    public ResponseEntity<?> listarCarroPorId(@PathVariable Long idCarro) {
        Carro carro = carroService.listarPorId(idCarro);
        if (carro != null) {
            return ResponseEntity.ok(carro);
        } else {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }
    @PostMapping
    // POST
    public Carro criar(@Valid @RequestBody Carro carro) {
        return carroService.criar(carro);
    }

    @PutMapping("/{idCarro}")
    //PUT
    public ResponseEntity<?> atualizar(@PathVariable Long idCarro, @RequestBody Carro carro) {
        if(carroService.atualizar(carro, idCarro) == null) {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(carro);
    }

    @DeleteMapping("/{idCarro}")
    public ResponseEntity<?> deletar(@PathVariable Long idCarro) {
        if (carroService.deletar(idCarro)) {
            String mensagem = "A deleção do id: " + idCarro + " foi realizada com sucesso";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }
    @GetMapping("/quantidade")
    // GET quantidade-carros
    public int quantidadeDeCarros() {
        return carroService.quantidade();
    }


    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<Carro>> listarPorMarca(@PathVariable String marca) {
        List<Carro> carros = carroService.listarPorMarca(marca);
        if (carros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carros, HttpStatus.OK);
    }

    @GetMapping("/precoMaiorQue10K")
    public ResponseEntity<List<Carro>> listarPrecoMaior10K() {
        List<Carro> carros = carroService.listarPorPrecoMaior10K();
        if (carros.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carros, HttpStatus.OK);
    }

}



