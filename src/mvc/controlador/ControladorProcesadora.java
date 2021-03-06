/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controlador;

import java.util.ArrayList;
import logica.modelo.Gestor;
import logica.modelo.Pedido;
import logica.modelo.ProcesadoraPedidos;
import logica.observador.Observable;
import logica.observador.Observador;
import mvc.IVistaProcesadora;

/**
 *
 * @author santi
 */
public class ControladorProcesadora implements Observador {

    private Gestor gestor;
    private ProcesadoraPedidos procesadora;

    private IVistaProcesadora vista;

    public ControladorProcesadora(Gestor gestor, ProcesadoraPedidos procesadora, IVistaProcesadora vista) {
        this.gestor = gestor;
        this.procesadora = procesadora;
        this.vista = vista;

        procesadora.agregarObservador(this);
                
        inicializarVista();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        //todos los gestores deben ser notificados que hay cambios en la procesadora
        if (evento.equals(ProcesadoraPedidos.eventos.actualizarPedidosProcesadora)) {
            actualizarPedidosProcesadora();
        }
    }

    private void inicializarVista() {
        vista.initLabels(gestor, procesadora);
        actualizarPedidosProcesadora();
        actualizarPedidosGestor();
    }

    public void prepararPedido(Pedido pedido) {
        if (pedido != null) {
            this.gestor.preparaPedido(pedido);
            actualizarPedidosGestor();
        }
        else {
            vista.mostrarError("Seleccione un pedido pendiente");
        }
    }

    public void finalizarPedido(Pedido pedido) {
        if (pedido != null) {
            this.gestor.pedidoPronto(pedido);
            actualizarPedidosGestor();
        }
        else {
            vista.mostrarError("Seleccione un pedido en curso");
        }
    }

    private void actualizarPedidosGestor() {
        //actualiza la lista de pedidos en curso del gestor
        vista.actualizarPedidosEnCurso(gestor.getPedidos());
    }

    private void actualizarPedidosProcesadora() {
        //actualizar lista de pedidos pendientes de la procesadora
        vista.actualizarPedidosPendientes(procesadora.getPedidos());
    }

}
