/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controlador.login;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import logica.Fachada;
import logica.excepciones.LogicException;
import logica.modelo.Mozo;
import logica.modelo.Usuario;
import mvc.IVistaLogin;
import mvc.vista.VistaAtencionMesas;
import mvc.vista.login.VistaLogin;

/**
 *
 * @author Sebastian
 */
public abstract class ControladorLogin {

    private IVistaLogin vista;

    public ControladorLogin(IVistaLogin vista) {
        this.vista = vista;
    }

    public void login(String username, String password) {
        Usuario user;
        try {
            user = llamarLogin(username, password);
            if (user != null) {
                vista.proximoCasoUso(user);
                vista.cerrar();
            }
        } catch (LogicException ex) {
            vista.mostrarError(ex);
        }
    }

    public abstract Usuario llamarLogin(String user, String psw) throws LogicException;
}
