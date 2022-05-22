/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import logica.modelo.Gestor;
import java.util.ArrayList;
import logica.modelo.Pedido;
import logica.observador.Observable;

/**
 *
 * @author Usuario
 */
public class ProcesadoraPedidos extends Observable{
    private String nombre;
    private ArrayList<Gestor> gestores = new ArrayList<Gestor>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();
    //agregar enum con los eventos
    
    public ProcesadoraPedidos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    
    
    public void agregarGestor(Gestor g){
        gestores.add(g);
    }
    
    public void agregarPedido(Pedido p) {
        //avisar con el evento "agregarPedido"
        pedidos.add(p);
    }

    public void asignarGestor(Gestor gestorActual) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
       return this.nombre;
    }
    
    
  
}
