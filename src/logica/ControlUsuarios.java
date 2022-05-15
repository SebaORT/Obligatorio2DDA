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
    private ArrayList<Gestor> gestores = new ArrayList<Gestor>();
    private ArrayList<Mozo> mozos = new ArrayList<Mozo>();

    public ArrayList<Mozo> getMozos() {
        return mozos;
    }

    public ArrayList<Gestor> getGestores() {
        return gestores;
    }

    public void agregarMozo(Mozo m){
        //Mozo m = new Mozo(usuario, password, nombreCompleto, telefono);
        mozos.add(m);
    }
    
    public void agregarGestor(Gestor g){
        //Gestor g = new Gestor(usuario,password,nombreCompleto);
        gestores.add(g);
    }
}
