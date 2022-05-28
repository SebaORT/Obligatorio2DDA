/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

import java.util.ArrayList;
import logica.excepciones.LogicException;

/**
 *
 * @author Usuario
 */
public class Mesa {

    private int numero;
    private Mozo mozo;
    private boolean abierta = false;
    private Servicio servicio;

    public Servicio getServicio() {
        return servicio;
    }

    public Mesa(int numero) {
        this.numero = numero;
        servicio = new Servicio(this);
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void abrirMesa() throws LogicException {
        if (!abierta) {
            abierta = true;

        } else {
            throw new LogicException("La mesa esta abierta.");
        }
    }

    /*
     * public void cerrarServicio(){
     * servicio.cerrarServicio();
     * }
     */
    public Mozo getMozo() {
        return mozo;
    }

    public void cerrarMesa() throws LogicException {
        if (abierta) {
            if (servicio.pedidosPendientes() == 0) {
                abierta = false;
                servicio.limpiarServicio();
            } else
                throw new LogicException("Tiene pedidos pendientes");
        } else
            throw new LogicException("La mesa no está abierta");
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }

    public void agregarMozo(Mozo m) {
        setMozo(m);
    }

    public int getNumero() {
        return numero;
    }
    
    
    
    public void hacerTranferencia(Mozo mozoDestino){
        
    }
    
    @Override
    public String toString() {
        return "Mesa "+numero;
    }
    
    

    
}
