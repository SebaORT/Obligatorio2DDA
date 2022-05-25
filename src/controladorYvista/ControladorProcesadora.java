/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladorYvista;


import logica.ProcesadoraPedidos;
import logica.observador.Observable;
import logica.observador.Observador;

/**
 *
 * @author santi
 */
public class ControladorProcesadora implements Observador{
    
    
    private ProcesadoraPedidos modelo;
    private VistaProcesadora vista;

    public ControladorProcesadora(ProcesadoraPedidos modelo, VistaProcesadora vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    

    @Override
    public void actualizar(Object evento, Observable origen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
