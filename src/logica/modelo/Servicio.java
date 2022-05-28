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
public class Servicio {
    
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private Mesa mesa;
    private Cliente cliente;
    
    public Servicio(Mesa mesa){
        this.mesa = mesa;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    
    public void agregarCliente(Cliente c){
        cliente=c;
    }
    
    public int calcularServicio(){
        int resultado = 0;
        for(Pedido p:pedidos){
            resultado += p.getMontoPedido();
        }
        return resultado;
    }
    
    public void crearPedido(Producto producto,int cantidad,String descripcion) throws LogicException{
        Pedido p = new Pedido(this);
        if(mesa.isAbierta()){
                p.agregarProducto(producto, cantidad,descripcion);
                pedidos.add(p);
                producto.getUnidadProcesadora().agregarPedido(p);
        }
        else throw new LogicException("La mesa esta cerrada.");
    }
    /*
    public void cerrarServicio() {
        calcularServicio();
    }
    */
    public int pedidosPendientes(){
        int pendientes=0;
        for (Pedido p: pedidos){
            if(p.getEstado()!= "servido")
                pendientes =+ 1;
        }
        return pendientes;
    }

    public void limpiar() {
        pedidos.clear();
    }

    
    
}