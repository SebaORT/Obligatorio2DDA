/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

import java.util.ArrayList;
import logica.Cliente;
import logica.excepciones.LogicException;

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
    
    public void abrirCerrarMesa() throws LogicException{
        if(!abierta){
            abierta=true;
        }
        else{
           throw new LogicException("La mesa esta abierta.");
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
    
    //No se si esto esta bien
    public void agregarPedido(Producto producto,int cantidad,String descripcion) throws LogicException{
        Pedido p = new Pedido();
        if(abierta){
            try{
                p.agregarProducto(producto, cantidad,descripcion);
                servicio.add(p);
            }catch(LogicException e){
            }
        }
        else{
            throw new LogicException("La mesa esta cerrada.");
        }
    }
    
    public void cerrarServicio(){
        servicio.clear();
    }
    
    

    public Mozo getMozo() {
        return mozo;
    }
    

    private void cerrarMesa() throws LogicException {
        if(servicio.size() == 0){
            cliente = null;
            abierta=false;
        }
        else{
           throw new LogicException("debe cerrar el servicio antes de cerrar la mesa");
        }
    }

    public void setMozo(Mozo mozo) {
        this.mozo = mozo;
    }
    
    public void agregarMozo(Mozo m){
        setMozo(m);
    }
    
    
    
}
