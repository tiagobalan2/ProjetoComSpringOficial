package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Bicicleta extends Veiculo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBicicleta;

    @NotNull(message = "O aro da bicicleta deve ser obrigatoriamente informado")
    @Column(nullable = false)
    private int aro;

    @NotNull(message = "O tipo de terreno da bicicleta deve ser obrigatoriamente informado")
    @Column(nullable = false)
    private String Terreno;

    public Bicicleta() {
    }

    public Bicicleta(long idBicicleta, int aro, String terreno) {
        this.idBicicleta = idBicicleta;
        this.aro = aro;
        Terreno = terreno;
    }

    public Bicicleta(String marca, String cor, double preco, String ano, long idBicicleta, int aro, String terreno) {
        super(marca, cor, preco, ano);
        this.idBicicleta = idBicicleta;
        this.aro = aro;
        Terreno = terreno;
    }

    public long getIdBicicleta() {
        return idBicicleta;
    }

    public void setIdBicicleta(long idBicicleta) {
        this.idBicicleta = idBicicleta;
    }

    public int getAro() {
        return aro;
    }

    public void setAro(int aro) {
        this.aro = aro;
    }

    public String getTerreno() {
        return Terreno;
    }

    public void setTerreno(String terreno) {
        Terreno = terreno;
    }
}
