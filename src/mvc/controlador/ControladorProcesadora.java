/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controlador;


import logica.modelo.Gestor;
import logica.modelo.ProcesadoraPedidos;
import logica.observador.Observable;
import logica.observador.Observador;
import mvc.IVistaProcesadora;

/**
 *
 * @author santi
 */
public class ControladorProcesadora implements Observador{
    
    
    private Gestor gestor;
    private IVistaProcesadora vista;

    public ControladorProcesadora(Gestor gestor, IVistaProcesadora vista) {
        this.gestor = gestor;
        this.vista = vista;
        
        gestor.agregarObservador(this);
    }
    
    

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Gestor.eventos.actulizarPedidosProcesadora)){
            vista.actulizazPedidosProcesadora();
        }
        if(evento.equals(Gestor.eventos.actulizarMisPedidos)){
            //actuliza mi lista de pedidos como gestor
        }
    }
    
}
