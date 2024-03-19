package com.example.demo.controller;

import com.example.demo.model.Bicicleta;
import com.example.demo.model.Carro;
import com.example.demo.service.BicicletaService;
import com.example.demo.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bicicletas")
public class BicicletaController {
    @Autowired
    BicicletaService bicicletaService;

    @GetMapping
    // GET
    public List<Bicicleta> listarBicicletas() {
        return bicicletaService.listar();
    }

    @GetMapping("/{idBicicleta}")
    public ResponseEntity<?> listaBicicletaPorId(@PathVariable Long idBicicleta) {
        Bicicleta bicicleta = bicicletaService.listarPorId(idBicicleta);
        if (bicicleta != null) {
            return ResponseEntity.ok(bicicleta);
        } else {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }
    @PostMapping
    // POST
    public Bicicleta criar(@Valid @RequestBody Bicicleta bicicleta) {
        return bicicletaService.criar(bicicleta);
    }

    @PutMapping("/{idBicicleta}")
    //PUT
    public ResponseEntity<?> atualizar(@PathVariable Long idBicicleta, @RequestBody Bicicleta bicicleta) {
        if(bicicletaService.atualizar(bicicleta, idBicicleta) == null) {
            String mensagem = "O id informado não existe na base de dados";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
        return ResponseEntity.ok(bicicleta);
    }

    @DeleteMapping("/{idBicicleta}")
    public ResponseEntity<?> deletar(@PathVariable Long idBicicleta) {
        if (bicicletaService.deletar(idBicicleta)) {
            String mensagem = "A deleção do id: " + idBicicleta + " foi realizada com sucesso";
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
        }
        String mensagem = "O id informado não existe na base de dados";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }
    @GetMapping("/quantidade-bicicletas")
    // GET quantidade-bicicletas
    public int quantidadeDeBicicletas() {
        return bicicletaService.quantidade();
    }
}
