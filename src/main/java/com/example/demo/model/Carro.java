package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Carro extends Veiculo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCarro;

    // private String Placa;
    // private String numeroChassi

    @NotNull(message = "O numero de portas do carro deve ser obrigatoriamente informado")
    @Column(nullable = false)
    private int numeroPortas;
    @NotNull(message = "O tipo do cambio do carro deve ser obrigatoriamente informado")
    @Column(nullable = false)
    private String cambio;

    public Carro() {

    }


    public Carro(long idCarro, int numeroPortas, String cambio) {
        this.idCarro = idCarro;
        this.numeroPortas = numeroPortas;
        this.cambio = cambio;
    }

    public Carro(String marca, String cor, double preco, String ano, long idCarro, int numeroPortas, String cambio) {
        super(marca, cor, preco, ano);
        this.idCarro = idCarro;
        this.numeroPortas = numeroPortas;
        this.cambio = cambio;
    }


    public long getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(long idCarro) {
        this.idCarro = idCarro;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }
}
