/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Karine Pires
 */
public class Planta {
    private String nome;
    private String especie;
    private double alturaMaxima;
    private String dataPlantio;
    
    public Planta(String nome, String especie, double alturaMaxima, String dataPlantio){
        this.nome = nome;
        this.especie = especie;
        this.alturaMaxima = alturaMaxima;
        this.dataPlantio = dataPlantio;
    }

    public Planta() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public double getAlturaMaxima() {
        return alturaMaxima;
    }

    public void setAlturaMaxima(double alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }

    public String getDataPlantio() {
        return dataPlantio;
    }

    public void setDataPlantio(String dataPlantio) {
        this.dataPlantio = dataPlantio;
    }
    
}
