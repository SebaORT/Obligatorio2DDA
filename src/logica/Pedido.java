/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Usuario
 */
public class Pedido {
    
    private Producto producto;
    private int cantidad;
    
    public void agregarProducto(Producto p, int cantidad){
        if(p.actulizarStock(cantidad)){
            producto = p;
        }
    }
    
}
