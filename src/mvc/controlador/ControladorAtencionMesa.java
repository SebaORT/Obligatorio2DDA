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
import mvc.vista.VistaAtencionMesas;

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
    }

    private void inicializarVista() {

        ArrayList<Pedido> servicioActual = new ArrayList<>();
        vista.updateServicioActual(servicioActual);

        ArrayList<Mesa> mesasMozo = mozo.getMesas();
        vista.initMesasUI(mesasMozo);
        vista.updateListaProductos(Fachada.getInstancia().getProductosConStock());
        vista.initLabels(mozo);
    }

    public void AbrirMesa(int indexMesaSeleccionada) {
        try {
            this.mozo.getMesas().get(indexMesaSeleccionada).abrirMesa();
        } catch (LogicException ex) {
            vista.mostrarExceptionError(ex);
        }
    }

    public void CerrarMesa(int indexMesaSeleccionada) {
        try {
            this.mozo.getMesas().get(indexMesaSeleccionada).cerrarMesa();
        } catch (LogicException ex) {
            vista.mostrarExceptionError(ex);
        }
    }

    public void UpdateServicioActual(int indexMesaSeleccionada) {
        if (mozo.getMesas().get(indexMesaSeleccionada).isAbierta()) {
            vista.updateServicioActual(mozo.obtenerPedidosServicio(indexMesaSeleccionada));
        } else {
            vista.updateServicioActual(new ArrayList<>());
        }
    }

    public void agregarProducto(int indexMesaSeleccionada, Producto prod, int cantidad, String description) {
        try {
             if (indexMesaSeleccionada >= 0) {
                mozo.agregarProductoAlServicio(indexMesaSeleccionada,prod, cantidad, description);
                vista.updateServicioActual(mozo.obtenerPedidosServicio(indexMesaSeleccionada));
                vista.mostrarMensaje("Producto agregado al servicio correctamente.");
             }
             else {
                vista.mostrarMensaje("Seleccione una mesa!");
             }             
        } catch (LogicException ex) {
            vista.mostrarExceptionError(ex);
        }
    }

    public void logout() {
        Fachada.getInstancia().logoutMozo(mozo);
    }

}
