package Modelo;

import java.util.List;

/**
 *
 * @author Karine Pires
 */
public interface PlantaRepository {
    
     public void adicionarPlanta(Planta planta);
     public List<Planta> listarPlantas();
     public void atualizarPlanta(Planta planta);
     public void removerPlanta(Planta planta);
     
}
