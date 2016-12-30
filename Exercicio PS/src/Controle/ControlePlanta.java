/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Planta;
import Modelo.PlantaDAO;
import Modelo.PlantaDAOArquivo;
import Modelo.PlantaRepository;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Karine Pires
 */
public class ControlePlanta {
    /*
     1 - Para gravar em Postgre
     2 - Para gravar em Mysql
     3 - Para gravar em arquivo de texto
     */
    private final int tipoGravacao = 3;

    PlantaRepository plantaRepository;

    public ControlePlanta() {
        try {
            this.plantaRepository = escolhaTipoGravacao(tipoGravacao);
        } catch (Exception e) {
        e.printStackTrace();
        }
        
    }

    public void adicionarPlanta(String nome, String especie, double alturaMaxima, String dataPlantio) throws ClassNotFoundException, IOException {
        Planta planta = new Planta(nome, especie, alturaMaxima, dataPlantio);

        plantaRepository.adicionarPlanta(planta);
    }

    public List<Planta> listarPlantas() throws ClassNotFoundException, IOException {
        return plantaRepository.listarPlantas();
    }

    public void atualizarPlanta(String nome, String especie, double alturaMaxima, String dataPlantio) throws ClassNotFoundException, IOException {
        Planta planta = new Planta(nome, especie, alturaMaxima, dataPlantio);

        plantaRepository.atualizarPlanta(planta);
    }

    public void removerPlanta(String nome, String especie, double alturaMaxima, String dataPlantio) throws ClassNotFoundException, IOException {
        Planta planta = new Planta(nome, especie, alturaMaxima, dataPlantio);

        plantaRepository.removerPlanta(planta);
    }

    public PlantaRepository escolhaTipoGravacao(int tipoGravacao) throws ClassNotFoundException, IOException {
        if (tipoGravacao == 1 || tipoGravacao == 2) {
            return new PlantaDAO();
        } else if (tipoGravacao == 3) {
            return new PlantaDAOArquivo();
        }
        return null;
    }

}
