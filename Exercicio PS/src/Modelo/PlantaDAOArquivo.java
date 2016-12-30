package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karine Pires
 */
public class PlantaDAOArquivo implements PlantaRepository {

    FileWriter arq;
    PrintWriter gravarArq;

    public PlantaDAOArquivo() throws IOException {
        arq = new FileWriter("C:\\Users\\Public\\viveiro.txt");
        gravarArq = new PrintWriter(arq);
    }

    @Override
    public void adicionarPlanta(Planta planta) {
        gravarArq.printf("nome = %s%n", planta.getNome());
        gravarArq.printf("especie = %s%n", planta.getEspecie());
        gravarArq.printf("altura_maxima = %f%n", planta.getAlturaMaxima());
        gravarArq.printf("data_plantio = %tD %n%n", planta.getDataPlantio());
        
        try {
            arq.close();
        } catch (IOException ex) {
            Logger.getLogger(PlantaDAOArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Planta> listarPlantas() {
        List plantas = new ArrayList<>();

        try {
            FileReader arqL = new FileReader("C:\\Users\\Public\\viveiro.txt");
            BufferedReader lerArq = new BufferedReader(arqL);

            String linha = lerArq.readLine();

            while (linha != null) {
                Planta planta = new Planta();

                String aux = linha.substring(0, 1);
                if (aux.equals("no")) {
                    planta.setNome(linha.substring(7));
                } else if (aux.equals("es")) {
                    planta.setEspecie(linha.substring(10));
                } else if (aux.equals("al")) {
                    Double altura = Double.parseDouble(linha.substring(15));
                    planta.setAlturaMaxima(altura);
                } else if (aux.equals("da")) {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    planta.setDataPlantio(linha.substring(15));
                }
                plantas.add(planta);
                linha = lerArq.readLine();
            }
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return plantas;
    }

    @Override
    public void atualizarPlanta(Planta planta) {
        String arquivo = "C:\\Users\\Public\\viveiro.txt";
        String arquivoTmp = "C:\\Users\\Public\\viveiro-tmp";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
            BufferedReader reader = new BufferedReader(new FileReader(arquivo));

            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("nome = " + linha.substring(7))) {
                    linha = linha.replace("nome = " + linha.substring(7), "nome = " + planta.getNome());
                }
                if (linha.contains("especie = " + linha.substring(10))) {
                    linha = linha.replace("especie = " + linha.substring(10), "especie = " + planta.getEspecie());
                }
                if (linha.contains("altura_maxima = " + linha.substring(15))) {
                    linha = linha.replace("altura_maxima = " + linha.substring(15), "altura_maxima = " + planta.getAlturaMaxima());
                }
                if (linha.contains("data_plantio = " + linha.substring(15))) {
                    linha = linha.replace("data_plantio = " + linha.substring(15), "data_plantio = " + planta.getDataPlantio());
                }

                writer.write(linha + "\n");
            }

            writer.close();
            reader.close();

            new File(arquivo).delete();
            new File(arquivoTmp).renameTo(new File(arquivo));

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public void removerPlanta(Planta planta) {
        String arquivo = "C:\\Users\\Public\\viveiro.txt";
        String arquivoTmp = "C:\\Users\\Public\\viveiro-tmp";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
            BufferedReader reader = new BufferedReader(new FileReader(arquivo));

            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.contains("nome = " + planta.getNome())) {
                    linha = linha.replace("nome = " + linha.substring(7), null);
                }
                if (linha.contains("especie = " + planta.getEspecie())) {
                    linha = linha.replace("especie = " + linha.substring(10), null);
                }
                if (linha.contains("altura_maxima = " + planta.getAlturaMaxima())) {
                    linha = linha.replace("altura_maxima = " + linha.substring(15), null);
                }
                if (linha.contains("data_plantio = " + planta.getDataPlantio())) {
                    linha = linha.replace("data_plantio = " + linha.substring(15), null);
                }

                writer.write(linha);
            }

            writer.close();
            reader.close();

            new File(arquivo).delete();
            new File(arquivoTmp).renameTo(new File(arquivo));

        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
