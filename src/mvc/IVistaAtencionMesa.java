/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mvc;

import java.util.ArrayList;
import logica.modelo.Mesa;
import logica.modelo.Mozo;
import logica.modelo.Pedido;
import logica.modelo.Producto;
import logica.modelo.Transferencia;

/**
 *
 * @author santi
 */
public interface IVistaAtencionMesa {
    
    public void updateServicioActual(ArrayList<Pedido> servicioActual); // tabla de pedidos por mesa
    public void initMesasUI(ArrayList<Mesa> mesasMozo); //botones magicos
    public void updateListaProductos(ArrayList<Producto> productos); // combobox de productos
    public void initLabels(Mozo mozo); //labels
    public void mostrarExceptionError(Exception ex); // mostrar error en la vista
    public void mostrarAlerta(String error);
    public void mostrarInfoPedidoListo(Pedido pedido);
    public void mostrarMensaje(String mensaje);

    public void setMesaAbierta(Mesa m);
    public void setMesaCerrada(Mesa m);
    
    public void cerrar();

    public void solicitacionTransferencia(Transferencia transf);
    
}
