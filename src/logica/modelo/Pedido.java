/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

import logica.excepciones.LogicException;

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
    private Servicio servicio;
    private status Estado = status.BuscandoGestor;
    
    
    public enum status{BuscandoGestor,EnPreparacion,Pronto};

    public status getEstado() {
        return Estado;
    }

    public void setEstado(status Estado) {
        this.Estado = Estado;
    }
    
    public void Pronto(){
        setEstado(status.Pronto);
        servicio.getMesa().getMozo().pedidoCambioEstado(this);
        servicio.getMesa().getMozo().pedidoEstadoPronto();
    }
    
    public boolean esMiMesa(Mesa otraMesa) {
        return servicio.getMesa() == otraMesa;
    }

    public Pedido(Servicio s) {
        this.servicio = s;
    }

    public void enPreparacion(){
        setEstado(status.EnPreparacion);
        servicio.getMesa().getMozo().pedidoCambioEstado(this);  
    }
    
    public Pedido(Producto producto, int cantidad, int montoPedido, String descripcion) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.montoPedido = montoPedido;
        this.descripcion = descripcion;
        this.gestor = gestor;
    }
    
    public void agregarProducto(Producto p, int cantidad, String desc)throws LogicException{
        if(cantidad >0){
            if(p.actualizarStock(cantidad)){
                producto = p;
                this.cantidad = cantidad;
                montoPedido = cantidad*p.getPrecio();
                descripcion = desc;
            }
            else { 
                throw new LogicException("Sin stock, solo quedan (" + p.getStock() + ").");
            }
        }
        else {
            throw new LogicException("cantidad inválida");
        }
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

    public Servicio getServicio() {
        return servicio;
    }

    @Override
    public String toString() {
       return "El Pedido : " + producto.getNombre() +" (#"+ cantidad + ") , de la Mesa: " + servicio.getMesa().getNumero() + " esta pronto!!";
    }

    
   
    
    
    
    
}
