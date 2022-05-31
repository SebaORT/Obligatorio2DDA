/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controlador.login;

import logica.Fachada;
import logica.excepciones.LogicException;
import logica.modelo.Usuario;
import mvc.IVistaLogin;

/**
 *
 * @author Sebastian
 */
public class ControladorLoginMozo extends ControladorLogin{

    public ControladorLoginMozo(IVistaLogin vista) {
        super(vista);
    }

    @Override
    public Usuario llamarLogin(String user, String psw) throws LogicException {
        return Fachada.getInstancia().loginMozo(user, psw);
    }
    
}
