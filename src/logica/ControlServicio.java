/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import logica.modelo.ProcesadoraPedidos;
import logica.modelo.Producto;
import java.util.ArrayList;
import logica.observador.Observable;

/**
 *
 * @author Usuario
 */
public class ControlServicio  {
    
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

    public ArrayList<ProcesadoraPedidos> getProcesadoras() {
        return procesadoras;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    ArrayList<Producto> getProductosConStock() {
        ArrayList<Producto> res = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getStock() > 0) {
                res.add(p);
            }
        }
        return res;
    }
    
    
}
