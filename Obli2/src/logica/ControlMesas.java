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
public class ControlMesas {
    private ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    
    public void agregarMesa(Mesa m){
        mesas.add(m);
    }
    
}
