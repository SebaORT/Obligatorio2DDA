/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

import java.util.ArrayList;
import logica.Cliente;

/**
 *
 * @author Usuario
 */
public class Mesa {
    
    private int numero;
    private Mozo mozo;
    private boolean abierta = false;
    private Cliente cliente;
    private ArrayList<Pedido> servicio = new ArrayList<Pedido>();


    public Mesa(int numero) {
        this.numero = numero;

    }
    
    public void abrirCerrarMesa(){
        if(!abierta){
            abierta=true;
        }
        else{
            cerrarMesa();
        } 
    }
    
    public int calcularServicio(){
        int resultado = 0;
        for(Pedido p:servicio){
            resultado += p.getMontoPedido();
        }
        return resultado;
    }
     
    public void agregarCliente(Cliente c){
        cliente=c;
    }
    
    public void agregarPedido(Pedido p){
        servicio.add(p);
    }
    
    public void cerrarServicio(){
        servicio.clear();
    }

    public Mozo getMozo() {
        return mozo;
    }
    

    private void cerrarMesa() {
        if(servicio.size() == 0){
            cliente = null;
            abierta=false;
        }
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }
    
    public void agregarMozo(Mozo m){
        setMozo(m);
    }
    
    
    
}
