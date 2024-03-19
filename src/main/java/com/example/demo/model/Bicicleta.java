package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Bicicleta extends Veiculo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBicicleta;
    private int aro;
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
