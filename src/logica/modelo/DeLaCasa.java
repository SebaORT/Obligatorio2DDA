/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

/**
 *
 * @author Usuario
 */
public class DeLaCasa extends TipoCliente{

    @Override
    public float montoAPagarConDescuento(Servicio servicio) {
        float tot = servicio.calcularServicio();
        if(tot>500){
            tot = tot-500;
        }
        else tot=0;
        return tot;
    }
    
    @Override
    public String toString() {
        return "De La Casa";
    }
}
