/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controlador;

import java.util.ArrayList;
import logica.Fachada;
import logica.excepciones.LogicException;
import logica.modelo.Mesa;
import logica.modelo.Mozo;
import logica.modelo.Pedido;
import logica.modelo.Producto;
import logica.observador.Observable;
import logica.observador.Observador;
import mvc.IVistaAtencionMesa;

/**
 *
 * @author santi
 */
public class ControladorAtencionMesa implements Observador {

    private Mozo mozo;
    private IVistaAtencionMesa vista;

    public ControladorAtencionMesa(Mozo mozo, IVistaAtencionMesa vista) {
        this.mozo = mozo;
        this.vista = vista;
        inicializarVista();

        mozo.agregarObservador(this);

    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Mozo.eventos.pedidoCambioEstado)) {
            Pedido pedido = mozo.getUltimoPedidoCambioEstado();
            vista.mostrarInfoPedidoListo(pedido);
        }
        if (evento.equals(Mozo.eventos.actualizarProductos)) {
            vista.updateListaProductos(Fachada.getInstancia().getProductosConStock());
        }
    }

    private void inicializarVista() {

        ArrayList<Pedido> servicioActual = new ArrayList<>();
        vista.updateServicioActual(servicioActual);

        ArrayList<Mesa> mesasMozo = mozo.getMesas();
        vista.initMesasUI(mesasMozo);
        vista.updateListaProductos(Fachada.getInstancia().getProductosConStock());
        vista.initLabels(mozo);
    }

    public void AbrirMesa(Mesa m) {
        try {
            m.abrirMesa();
            vista.setMesaAbierta(m);

        } catch (LogicException ex) {
            vista.mostrarExceptionError(ex);
        }
    }

    public void CerrarMesa(Mesa m) {
        try {
            m.cerrarMesa();
            vista.setMesaCerrada(m);
        } catch (LogicException ex) {
            vista.mostrarExceptionError(ex);
        }
    }

    public void UpdateServicioActual(Mesa m) {
        if (m.isAbierta()) {
            vista.updateServicioActual(m.getServicio().getPedidos());
        } else {
            vista.updateServicioActual(new ArrayList<>());
        }
    }

    public void agregarProductoAlServicio(Mesa m, Producto prod, int cantidad, String description) {
        try {
            if (m!= null) {
                m.getServicio().crearPedido(prod, cantidad, description);
                vista.updateServicioActual(m.getServicio().getPedidos());
                vista.mostrarMensaje("Producto agregado al servicio correctamente.");
            } else {
                vista.mostrarMensaje("Seleccione una mesa!");
            }
        } catch (LogicException ex) {
            vista.mostrarExceptionError(ex);
        }
    }

    public void logout() {
        try {
            Fachada.getInstancia().logoutMozo(mozo);
            vista.cerrar();
        } catch (LogicException ex) {
            vista.mostrarExceptionError(ex);
        }
    }

}
