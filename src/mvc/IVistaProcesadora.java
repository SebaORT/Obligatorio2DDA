/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mvc;

import java.util.ArrayList;
import logica.modelo.Gestor;
import logica.modelo.Pedido;
import logica.modelo.ProcesadoraPedidos;

/**
 *
 * @author santi
 */
public interface IVistaProcesadora {
    
    public void actualizarPedidosPendientes(ArrayList<Pedido> pedidos);
    public void actualizarPedidosEnCurso(ArrayList<Pedido> pedidos);
    
    public void initLabels(Gestor g, ProcesadoraPedidos p);

    public void mostrarError(String mensaje);
    
}
