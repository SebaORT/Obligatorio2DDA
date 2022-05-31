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

        gestor.agregarObservador(this);
        inicializarVista();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Gestor.eventos.actualizarPedidosProcesadora)) {
            vista.actualizarPedidosEnCurso(PedidosEncurso());
        }
        if (evento.equals(Gestor.eventos.actualizarMisPedidos)) {
            //actualiza mi lista de pedidos como gestor
            vista.actualizarPedidosPendientes(PedidosPendientes());
        }
    }

    private void inicializarVista() {
        vista.initLabels(gestor, procesadora);
        vista.actualizarPedidosPendientes(this.gestor.getPedidos());
        vista.actualizarPedidosEnCurso(this.procesadora.getPedidos());
    }

    public void prepararPedido(Pedido pedido) {
        this.gestor.preparaPedido(pedido);
    }

    public void finalizarPedido(Pedido pedido) {
        this.gestor.pedidoPronto(pedido);
    }
    
    public ArrayList<Pedido> PedidosPendientes(){
        return this.procesadora.getPedidos();
    }

    public ArrayList<Pedido> PedidosEncurso(){
        return this.gestor.getPedidos();
    }
}
