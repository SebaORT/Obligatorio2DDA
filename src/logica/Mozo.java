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
public class Mozo extends Usuario{
    private int telefono;
    private ArrayList<Mesa> mesas = new ArrayList<Mesa>();

    public Mozo(String nombreUsuario,String password, String nombreCompleto,int telefono) {
        super(nombreUsuario,password,nombreCompleto);
        this.telefono = telefono;
    }
    
    
    public void transferirMesa(Mozo mozo,Mesa mesa){
        mesas.remove(mesa);
        mozo.agregarMesa(mesa);
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public void setServicio(ArrayList<Mesa> servicio) {
        this.mesas = servicio;
    }
    
    public void validar(){
    }

    private void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }
    
    @Override
    public boolean equals(Object o){
        Mozo m = (Mozo) o;
        return m.getNombreUsuario().equalsIgnoreCase(super.getNombreUsuario());
    }
        
}