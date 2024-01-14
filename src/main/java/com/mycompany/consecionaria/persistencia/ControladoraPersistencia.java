package com.mycompany.consecionaria.persistencia;

import com.mycompany.consecionaria.logica.Automovil;
import com.mycompany.consecionaria.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    AutomovilJpaController automovilJPA = new AutomovilJpaController();

    public void crearAutomovil(Automovil auto) {
        automovilJPA.create(auto);
    }

    public ArrayList<Automovil> traerAutos() {
        List<Automovil> listita = automovilJPA.findAutomovilEntities();
        ArrayList<Automovil> listaAutos = new ArrayList<Automovil>(listita);
        return listaAutos;
    }

    public void eliminarAutomovil(int idEliminar) {
        try {
            automovilJPA.destroy(idEliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Automovil traerAutomovil(int idEditar) {
        return automovilJPA.findAutomovil(idEditar);
    }

    public void editarAutomovil(Automovil auto) {
        try {
            automovilJPA.edit(auto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
