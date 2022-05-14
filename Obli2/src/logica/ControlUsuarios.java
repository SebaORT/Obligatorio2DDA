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
public class ControlUsuarios {
    private ArrayList<Mozo> mozos = new ArrayList<Mozo>();
    private ArrayList<Gestor> gestores = new ArrayList<Gestor>();
    
    public void agregarMozo(Mozo m){
        mozos.add(m);
    }
    
    public void agregarGestor(Gestor g){
        gestores.add(g);
    }
}
