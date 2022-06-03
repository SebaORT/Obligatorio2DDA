/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.vista.login;

import javax.swing.JDialog;
import logica.modelo.Mozo;
import logica.modelo.Usuario;
import mvc.IVistaLogin;
import mvc.controlador.login.ControladorLogin;
import mvc.controlador.login.ControladorLoginGestor;
import mvc.controlador.login.ControladorLoginMozo;
import mvc.vista.VistaAtencionMesas;

/**
 *
 * @author Sebastian
 */
public class VistaLoginAtencionMesas extends VistaLogin {

    public VistaLoginAtencionMesas(java.awt.Frame parent, boolean modal) {
        super(parent, modal,"Login Mozo");

    }

    @Override
    public ControladorLogin crearControlador(IVistaLogin vista) {
        return new ControladorLoginMozo(vista);
    }

    @Override
    public void proximoCasoUso(Usuario user) {
        JDialog d = new VistaAtencionMesas(null, false, (Mozo) user);
        d.setVisible(true);
        d.setLocationRelativeTo(null);
    }

}
