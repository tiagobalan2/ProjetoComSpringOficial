package com.example.demo.controller;

import com.example.demo.model.Carro;
import com.example.demo.model.Onibus;
import com.example.demo.service.OnibusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/onibus")
public class OnibusController {
    @Autowired
    OnibusService onibusService;

    @GetMapping
    // GET
    public List<Onibus> listarOnibus () {
        return onibusService.listar();
    }

    @GetMapping("/{idOnibus}")
    // GET POR ID
    public ResponseEntity<?> listarOnibusPorId(@PathVariable Long idOnibus) {
        Onibus onibus = onibusService.listarPorId(idOnibus);
        if (onibus != null) {
            return ResponseEntity.ok(onibus);
        } else {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @PostMapping
    //POST
    public Onibus criar(@Valid @RequestBody Onibus onibus) {
        return onibusService.criar(onibus);
    }

    @PutMapping("/{idOnibus}")
    //PUT
    public ResponseEntity<?> atualizar(@PathVariable Long idOnibus, @RequestBody Onibus onibus) {
        if (onibusService.atualizar(onibus, idOnibus) == null) {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(onibus);
    }

    @DeleteMapping("/{idOnibus}")
    public ResponseEntity<?> deletar(@PathVariable Long idOnibus) {
        if (onibusService.deletar(idOnibus)) {
            String mensagem = "A deleção do id: " + idOnibus + " foi realizada com sucesso";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    @GetMapping("/quantidade")
    // GET quantidade de carros
    public int quantidadeDeOnibus() {
        return onibusService.quantidade();
    }


    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<Onibus>> listarPorMarca(@PathVariable String marca) {
        List<Onibus> onibus = onibusService.listarPorMarca(marca);
        if (onibus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(onibus, HttpStatus.OK);
    }

    @GetMapping("/precoMaiorQue10K")
    public ResponseEntity<List<Onibus>> listarPrecoMaior10K() {
        List<Onibus> onibus = onibusService.listarPorPrecoMaior10K();
        if (onibus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(onibus, HttpStatus.OK);
    }

}


