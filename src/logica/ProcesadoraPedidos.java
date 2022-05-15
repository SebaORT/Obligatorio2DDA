/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ProcesadoraPedidos {
    private String nombre;
    private ArrayList<Gestor> gestores = new ArrayList<Gestor>();

    public ProcesadoraPedidos(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarGestor(Gestor g){
        gestores.add(g);
    }

    
}
