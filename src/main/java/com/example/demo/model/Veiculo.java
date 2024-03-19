package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.websocket.ClientEndpoint;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Veiculo {

    @NotNull(message = "A marca do veiculo deve ser obrigatoriamente informada")
    @Column(nullable = false)
    private String marca;
    private String cor;

    @Column(nullable = false)
    @DecimalMin(value = "0.1")
    private double preco;
    @NotNull(message = "Campo ano não pode ser nulo.")
    @Column(nullable = false)
    @Size(min = 4)
    private String ano;

    public Veiculo() {
    }

    public Veiculo(String marca, String cor, double preco, String ano) {;
        this.marca = marca;
        this.cor = cor;
        this.preco = preco;
        this.ano = ano;
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
