/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

import logica.excepciones.LogicException;
import logica.excepciones.RestoException;

/**
 *
 * @author Usuario
 */
public class Pedido {
    
    private Producto producto;
    private int cantidad;
    private int montoPedido;
    private String descripcion;
    private Gestor gestor;

    public Pedido(Producto producto, int cantidad, int montoPedido, String descripcion) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.montoPedido = montoPedido;
        this.descripcion = descripcion;
        this.gestor = gestor;
    }
    
    
    
    public void agregarProducto(Producto p, int cantidad)throws LogicException{
        if(p.actulizarStock(cantidad)){
            producto = p;
            this.cantidad = cantidad;
            montoPedido = cantidad*p.getPrecio();
        }
        else throw new LogicException("La cantidad" + cantidad + "es major a el stock del producto (" + p.getStock() + ").");
    }

    public int getCantidad() {
        return cantidad;
    }

    public Gestor getGestor() {
        return gestor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    public Producto getProducto() {
        return producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setMontoPedido(int montoPedido) {
        this.montoPedido = montoPedido;
    }
    
    
    
    public void gestorPreparador(Gestor g){
        setGestor(g);
    }

    public int getMontoPedido() {
        return montoPedido;
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor;
    }
    
    
    
    
}
