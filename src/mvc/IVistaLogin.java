/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc;

import logica.modelo.Usuario;

/**
 *
 * @author Sebastian
 */
public interface IVistaLogin {

    public void cerrar();

    public void mostrarError(Exception ex);

    public void proximoCasoUso(Usuario user);
    
}
