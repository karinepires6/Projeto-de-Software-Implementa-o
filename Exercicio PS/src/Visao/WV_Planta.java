/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ControlePlanta;
import Modelo.Planta;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Karine Pires
 */
public class WV_Planta {

    public static void main(String[] args) throws ClassNotFoundException, IOException, ParseException {
        int opcao;
        String nome;
        String especie;
        double alturaMaxima;
        String dataPlantio;
        int tipoGravacao;
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        List<Planta> listaPlantas;
        
        ControlePlanta controller = new ControlePlanta();
        
        opcao = Integer.parseInt(JOptionPane.showInputDialog("------TABELA DE OPERAÇÕES------\n"
                + "1 - Para adicionar uma planta\n" + "2 - Para listar as plantas\n" +
                "3 - Para atualizar os dados de uma planta\n" + "4 - Para remover uma planta\n"
                + "0 - Para SAIR\n"));

        while (opcao != 0) {
            if (opcao == 1) {
                nome = JOptionPane.showInputDialog("Informe o nome da planta");
                especie = JOptionPane.showInputDialog("Informe a especie da planta");
                alturaMaxima = Double.parseDouble(JOptionPane.showInputDialog("Informe a altura maxima da planta"));
                dataPlantio = JOptionPane.showInputDialog("Informe a data de plantio");
                controller.adicionarPlanta(nome, especie, alturaMaxima, dataPlantio);
            } else if (opcao == 2) {
                System.out.println("------Listando plantas------");
                listaPlantas = controller.listarPlantas();
                for(Planta planta : listaPlantas){
                    System.out.println("NOME: " + planta.getNome());
                    System.out.println("NOME ESPECIE: " + planta.getEspecie());
                    System.out.println("DATA PLANTIO: " + planta.getDataPlantio());
                    System.out.println("ALTURA MAXIMA: " + planta.getAlturaMaxima());
                }
            } else if (opcao == 3) {
                nome = JOptionPane.showInputDialog("Informe o nome da planta");
                especie = JOptionPane.showInputDialog("Informe a especie da planta");
                alturaMaxima = Double.parseDouble(JOptionPane.showInputDialog("Informe a altura maxima da planta"));
                dataPlantio = JOptionPane.showInputDialog("Informe a data de plantio");
                controller.atualizarPlanta(nome, especie, alturaMaxima, dataPlantio);
            } else if (opcao == 4) {
                nome = JOptionPane.showInputDialog("Informe o nome da planta");
                especie = JOptionPane.showInputDialog("Informe a especie da planta");
                alturaMaxima = Double.parseDouble(JOptionPane.showInputDialog("Informe a altura maxima da planta"));
                dataPlantio = JOptionPane.showInputDialog("Informe a data de plantio");
                controller.removerPlanta(nome, especie, alturaMaxima, dataPlantio);
            } else {
                System.out.println("Opção invalida :(");
            }
            opcao = Integer.parseInt(JOptionPane.showInputDialog("------TABELA DE OPERAÇÕES------\n"
                + "1 - Para adicionar uma planta\n" + "2 - Para listar as plantas\n" +
                "3 - Para atualizar os dados de uma planta\n" + "4 - Para remover uma planta\n"
            + "0 - Para SAIR\n"));
        }

    }
}
