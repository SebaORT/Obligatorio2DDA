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
    private Gestor gestor;
    
    public void agregarProducto(Producto p, int cantidad)throws LogicException{
        if(p.actulizarStock(cantidad)){
            producto = p;
            this.cantidad = cantidad;
            montoPedido = cantidad*p.getPrecio();
        }
        else throw new LogicException("La cantidad" + cantidad + "es major a el stock del producto (" + p.getStock() + ").");
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
