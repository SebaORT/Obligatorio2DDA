/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelo;

import logica.modelo.Usuario;
import java.util.ArrayList;
import java.util.Date;
import logica.ProcesadoraPedidos;

/**
 *
 * @author Usuario
 */


public class Gestor extends Usuario {

    private Date fechaUltimoAcceso= new Date();
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private ProcesadoraPedidos procesadoraPedidos;

    public Gestor(String nombreUsuario, String password, String nombreCompleto) {
        super(nombreUsuario, password, nombreCompleto);
    }

   
      public void ultimoAcceso(){
      Date nuevaFecha = new Date();
      setFechaUltimoAcceso(nuevaFecha);
      }
      public Date getFechaUltimoAcceso() {
      return fechaUltimoAcceso;
      }
      public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
      this.fechaUltimoAcceso = fechaUltimoAcceso;
      }
    

    public void preparaPedido(Pedido p){
        pedidos.add(p);
        p.gestorPreparador(this);
        p.setEstado("En preparacion");
        procesadoraPedidos.sacarPedido(p);
    }

    public void validar() {
    }

    public void asignarProcesadora(ProcesadoraPedidos procesadoraSeleccionada) {
        procesadoraPedidos = procesadoraSeleccionada;
    }

    public void pedidoPronto(Pedido p) {
        if (pedidos.contains(p)) {
            pedidos.remove(p);
            p.setEstado("Pronto");
            
            p.getServicio().getMesa().getMozo().pedidoCambioEstado(p);
                    
                   // avisar(Mozo.eventos.pedidoCambioEstado);
            //aca se deberia avisar al mozo que el pedido esta pronto 
        } else {

        }
    }

    @Override
    public boolean equals(Object o) {
        Gestor g = (Gestor) o;
        return g.getNombreUsuario().equalsIgnoreCase(super.getNombreUsuario());
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    
    

}
