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
     
    public void agregarCliente(Cliente c){
        cliente=c;
    }
    
    public void agregarPedido(Pedido p){
        servicio.add(p);
    }

    private void cerrarMesa() {
        servicio.clear();//no se si se borran asi todo los elementos de una lista y tienen que pasar mas cosa cuando se sierra la mesa
        
        cliente = null;
        abierta=false;
    }
    
    
    
}
