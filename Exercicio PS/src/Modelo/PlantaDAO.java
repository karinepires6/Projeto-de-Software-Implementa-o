/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Util.ConnectionFactoryPostgre;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class PlantaDAO implements PlantaRepository {

    private Connection connection;

    public PlantaDAO() throws ClassNotFoundException {
        this.connection = new ConnectionFactoryPostgre().getConnection();
    }

    @Override
    public void adicionarPlanta(Planta planta) {
        String sql = "INSERT INTO planta (nome, especie, altura_maxima, data_plantio) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, planta.getNome());
            stmt.setString(2, planta.getEspecie());
            stmt.setDouble(3, planta.getAlturaMaxima());
            stmt.setDate(4, new java.sql.Date ((long) planta.getAlturaMaxima()));
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Planta> listarPlantas() {
        List plantas = new ArrayList<>();
        String sql = "SELECT * FROM planta";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Planta planta = new Planta();
                planta.setNome(rs.getString("nome"));
                planta.setEspecie(rs.getString("especie"));
                planta.setAlturaMaxima(rs.getDouble("altura_maxima"));
                planta.setDataPlantio(rs.getString("data_plantio"));

                plantas.add(planta);
            }

            return plantas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizarPlanta(Planta planta) {
        String sql = "UPDATE Planta SET nome = ?, especie = ?, altura_maxima = ?, data_plantio = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, planta.getNome());
            stmt.setString(2, planta.getEspecie());
            stmt.setDouble(3, planta.getAlturaMaxima());
            stmt.setDate(4, new java.sql.Date ((long) planta.getAlturaMaxima()));
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removerPlanta(Planta planta) {
        String sql = "DELETE FROM Planta WHERE nome = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(0, planta.getNome());
            stmt.execute();
            stmt.close();
        
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

}
