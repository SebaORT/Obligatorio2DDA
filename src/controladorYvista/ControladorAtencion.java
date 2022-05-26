/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorYvista;

import logica.modelo.Mozo;
import logica.observador.Observable;
import logica.observador.Observador;

/**
 *
 * @author santi
 */
public class ControladorAtencion implements Observador{
    
    private Mozo modelo;
    private VistaAtencion vista;

    public ControladorAtencion(Mozo modelo, VistaAtencion vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    

    @Override
    public void actualizar(Object evento, Observable origen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
