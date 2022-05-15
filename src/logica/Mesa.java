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

    Mesa(int numero, Mozo mozo) {
        this.numero = numero;
        this.mozo = mozo;
    }
    
    public void abrirCerrarMesa(){
        if(!abierta){
            abierta=true;
        }
        else abierta=false;
    }
    
    public void estaAbierta(){
    }
    
    public void agregarCliente(){
    }
    
    public void agregarPedido(){
    }
    
    
    
}
