/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import logica.modelo.Mozo;
import logica.modelo.Gestor;
import java.util.ArrayList;
import logica.excepciones.LogicException;
import logica.modelo.Usuario;

/**
 *
 * @author Usuario
 */
public class ControlUsuarios {
    private ArrayList<Gestor> gestores = new ArrayList<Gestor>();
    private ArrayList<Mozo> mozos = new ArrayList<Mozo>();
    private ArrayList<Usuario> usuariosConectados = new ArrayList<Usuario>();
    
    

    public ArrayList<Mozo> getMozos() {
        return mozos;
    }

    public ArrayList<Gestor> getGestores() {
        return gestores;
    }

    public void agregarMozo(Mozo m){
        mozos.add(m);
    }
    
    public void agregarGestor(Gestor g){
        gestores.add(g);
    }
    
    private Usuario login(String u,String p,ArrayList<Usuario> lista){
       
        for(Usuario usr:lista){
            if(usr.getNombreUsuario().equalsIgnoreCase(u) && 
                    usr.getPassword().equals(p)){
                    return usr;
            }
        }
        return null;
    }
    
    public Mozo loginMozo(String nombre,String password) throws LogicException{
       Usuario usuario = login(nombre,password,(ArrayList)mozos);
       if (usuario!=null){
           if(!usuariosConectados.contains(usuario)){
               usuariosConectados.add(usuario);
            return (Mozo)usuario;
           }
           else throw new LogicException("Ud. ya está logueado");
        }
       else throw new LogicException("Nombre de usuario y/o contraseña incorrectos");
    }
    
    
    public Gestor loginGestor(String u,String p) throws LogicException{
        Usuario usu = login(u,p,(ArrayList)gestores);
        if(usu!=null){
            if(!usuariosConectados.contains(usu)){
                Gestor g = (Gestor)usu;
                g.ultimoAcceso();
                return g; 
            }
            else throw new LogicException("Ud. ya está logueado");
        }
        else throw new LogicException("Nombre de usuario y/o contraseña incorrectos");
    }
    
    public void logoutMozo(Mozo m){
        if(m.mesasCerradas()){
            usuariosConectados.remove(m);
        }
    }
   
}
