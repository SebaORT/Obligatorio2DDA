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
    
    
    public void transferirMesa(Mozo mozo,Mesa mesa)throws RestoException{
        mesas.remove(mesa);
        mozo.agregarMesa(mesa);
        //mesa.setMozo(mozo);
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

    private void agregarMesa(Mesa mesa)throws RestoException {
        if(mesas.size()>=5){
            throw new RestoException("El mozo ya tiene 5 mesas.");
        }
        else{
            mesas.add(mesa);
            mesa.setMozo(this);
        }
    }
    
    @Override
    public boolean equals(Object o){
        Mozo m = (Mozo) o;
        return m.getNombreUsuario().equalsIgnoreCase(super.getNombreUsuario());
    }
        
}
