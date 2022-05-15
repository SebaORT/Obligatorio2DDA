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
public class ControlServicio {
    
    private ArrayList<ProcesadoraPedidos> procesadoras = new ArrayList<ProcesadoraPedidos>();
    private ArrayList<Producto> productos = new ArrayList<Producto>();
    
    public void agregarPorcesadoraPedidos(ProcesadoraPedidos p){
        //ProcesadoraPedidos p = new ProcesadoraPedidos(nombre);
        procesadoras.add(p);
    }
    
    public void agregarProducto(Producto p){
        //Producto p = new Producto(codigo,nombre,precio,stock,unidadProcesadora);
        productos.add(p);
    }
}
