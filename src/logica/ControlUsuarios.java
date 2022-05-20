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
    private ArrayList<Conexion> conexiones = new ArrayList<Conexion>();

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
       if (usuario!=null) {
        return (Mozo)usuario;
       }
       else {
           throw new LogicException("Eror al tratar de loguear el mozo");
       }
    }
    
    public Gestor loginGestor(String u,String p){
        return (Gestor)login(u,p,(ArrayList)gestores);
        /*Gestor g = (Gestor)login(u,p,(ArrayList)gestores);
        Conexion c = null;
        if(g!=null){
            c = new Conexion(g);
            conexiones.add(c);
        }
       return c; */
    }
}
