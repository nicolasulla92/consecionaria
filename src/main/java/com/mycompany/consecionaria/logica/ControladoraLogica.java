package com.mycompany.consecionaria.logica;

import com.mycompany.consecionaria.igu.VisualizacionRED;
import com.mycompany.consecionaria.persistencia.ControladoraPersistencia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ControladoraLogica {
    
    ControladoraPersistencia ctrlPersistencia = new ControladoraPersistencia();

    public void guardarAutomovil(String marca, String modelo, String motor, String color, String patente) {
        Automovil auto = new Automovil(0, modelo, marca, motor, color, patente);
        ctrlPersistencia.crearAutomovil(auto);
    }

    public ArrayList<Automovil> traerAutos() {   
        return ctrlPersistencia.traerAutos();
    }

    public void eliminarAutomovil(int idEliminar) {
        ctrlPersistencia.eliminarAutomovil(idEliminar);
    }

    public Automovil traerAutomovil(int idEditar) {
        return ctrlPersistencia.traerAutomovil(idEditar);
    }    

    public void guardarEdicion(int idEditar, String marca, String modelo, String motor, String color, String patente) {
        Automovil auto = new Automovil(idEditar, modelo, marca, motor, color, patente);
        ctrlPersistencia.editarAutomovil(auto);
    }

    public void altaMasiva(String rutaArchivo) {
        Automovil auto = new Automovil();
                try {
            // Abre el archivo para lectura utilizando BufferedReader
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));

            // Lee línea por línea e imprime el contenido
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] atributos = linea.split(",");
                auto.setId(Integer.parseInt(atributos[0]));
                auto.setMarca(atributos[1]);
                auto.setModelo(atributos[2]);
                auto.setMotor(atributos[3]);
                auto.setColor(atributos[4]);
                auto.setPatente(atributos[5]);
                ctrlPersistencia.crearAutomovil(auto);
            }

            // Cierra el BufferedReader después de leer el archivo
            lector.close();

        } catch (IOException e) {
            // Maneja las excepciones de entrada/salida (IOException) aquí
            e.printStackTrace();
        }
        VisualizacionRED pantalla = new VisualizacionRED();
        pantalla.setVisible(true);
        pantalla.setLocationRelativeTo(null);
    }
}
