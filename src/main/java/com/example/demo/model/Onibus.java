package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Onibus extends Veiculo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOnibus;

    @NotNull(message = "O tipo de serviço prestado pelo onibus deve ser obrigatoriamente informado")
    @Column(nullable = false)
    private String Servico;

    @NotNull(message = "A quantidade de passageiros do onibus deve ser obrigatoriamente informado")
    @Column(nullable = false)
    private String quantidadePassageiros;

    public Onibus() {
    }

    public Onibus(long idOnibus, String servico, String quantidadePassageiros) {
        this.idOnibus = idOnibus;
        Servico = servico;
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public Onibus(String marca, String cor, double preco, String ano, long idOnibus, String servico, String quantidadePassageiros) {
        super(marca, cor, preco, ano);
        this.idOnibus = idOnibus;
        Servico = servico;
        this.quantidadePassageiros = quantidadePassageiros;
    }

    public long getIdOnibus() {
        return idOnibus;
    }

    public void setIdOnibus(long idOnibus) {
        this.idOnibus = idOnibus;
    }

    public String getServico() {
        return Servico;
    }

    public void setServico(String servico) {
        Servico = servico;
    }

    public String getQuantidadePassageiros() {
        return quantidadePassageiros;
    }

    public void setQuantidadePassageiros(String quantidadePassageiros) {
        this.quantidadePassageiros = quantidadePassageiros;
    }
}
