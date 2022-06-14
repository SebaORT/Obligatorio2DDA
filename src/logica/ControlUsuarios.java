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
    private ArrayList<Usuario> mozosConectados = new ArrayList<Usuario>();
    private ArrayList<Usuario> gestoresConectados = new ArrayList<Usuario>();

    public ArrayList<Mozo> getMozos() {
        return mozos;
    }

    public ArrayList<Gestor> getGestores() {
        return gestores;
    }

    public void agregarMozo(Mozo m) {
        mozos.add(m);
    }

    public void agregarGestor(Gestor g) {
        gestores.add(g);
    }

    private Usuario login(String u, String p, ArrayList<Usuario> lista) {

        for (Usuario usr : lista) {
            if (usr.getNombreUsuario().equalsIgnoreCase(u) &&
                    usr.getPassword().equals(p)) {
                return usr;
            }
        }
        return null;
    }

    public Mozo loginMozo(String nombre, String password) throws LogicException {
        Usuario usuario = login(nombre, password, (ArrayList) mozos);
        if (usuario != null) {
            if (!mozosConectados.contains(usuario)) {
                mozosConectados.add(usuario);
                return (Mozo) usuario;
            } else
                throw new LogicException("Ud. ya está logueado");
        } else
            throw new LogicException("Nombre de usuario y/o contraseña incorrectos");
    }

    public ArrayList<Mozo> mozosAptosParaTransferir(Mozo mozoOrigen) {
        ArrayList<Mozo> resultado = new ArrayList<Mozo>();
        for (Usuario u : mozosConectados) {
            Mozo mozo = (Mozo) u;
            if (mozo.getMesas().size() < 5 && mozo!= mozoOrigen) {
                resultado.add(mozo);
            }
        }
        return resultado;
    }

    public Gestor loginGestor(String u, String p) throws LogicException {
        Usuario usu = login(u, p, (ArrayList) gestores);
        if (usu != null) {
            if (!gestoresConectados.contains(usu)) {
                Gestor g = (Gestor) usu;
                gestoresConectados.add(g);
                g.ultimoAcceso();
                return g;
            } else
                throw new LogicException("Ud. ya está logueado");
        } else
            throw new LogicException("Nombre de usuario y/o contraseña incorrectos");
    }

    public void logoutMozo(Mozo m) throws LogicException {
        if (m.mesasCerradas()) {
            mozosConectados.remove(m);
        } else
            throw new LogicException("Debe cerrar las mesas abiertas antes de salir");
    }

}
