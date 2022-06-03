/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.vista.login;

import javax.swing.JDialog;
import logica.modelo.Gestor;
import logica.modelo.Usuario;
import mvc.IVistaLogin;
import mvc.controlador.login.ControladorLogin;
import mvc.controlador.login.ControladorLoginGestor;

/**
 *
 * @author Sebastian
 */
public class VistaLoginProcesadoraPedidos extends VistaLogin {

    public VistaLoginProcesadoraPedidos(java.awt.Frame parent, boolean modal) {
        super(parent, modal,"Login Gestor");
    }

    @Override
    public ControladorLogin crearControlador(IVistaLogin vista) {
        return new ControladorLoginGestor(vista);
    }

    @Override
    public void proximoCasoUso(Usuario user) {
        JDialog d = new DialogSeleccionarProcesadora(null, false, (Gestor) user);
        d.setVisible(true);
        d.setLocationRelativeTo(null);
    }
}
