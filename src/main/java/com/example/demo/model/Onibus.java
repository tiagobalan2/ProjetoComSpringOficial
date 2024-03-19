package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Onibus extends Veiculo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOnibus;
    private String Servico;
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
