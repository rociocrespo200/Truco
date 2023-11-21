package com.tallerwebi.dominio;

import java.util.ArrayList;
import java.util.List;

public class Partida {

    Integer cantidadDejugadores;



    private List<Equipo> equipos;
    private List<Usuario> jugadores;
    private List<Ronda> rondas;
    private Equipo equipoGanador;


    public Partida() {
        equipos = new ArrayList<>();
        rondas = new ArrayList<>();
        jugadores = new ArrayList<>();
    }

    public void agregarEquipo(Usuario jugador1, Usuario jugador2) {
        jugadores.add(jugador1);
        equipos.add(new Equipo(1, jugador1));

        jugadores.add(jugador2);
        equipos.add(new Equipo(2, jugador2));
    }


    public void iniciarRonda(List<Carta> cartas) {
        Ronda ronda = new Ronda(equipos, jugadores, cartas);
        rondas.add(ronda);
        ronda.repartir();

    }

    public int obtenerCantidadDeJugadores() {
        return jugadores.size();
    }

    public Ronda obtenerRondaActual() {

        return rondas.get(rondas.size()-1);
    }

    public boolean buscarUsuario(Usuario usuario) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getId().equals(usuario.getId())) return true;
        }
        return false;
    }

    public Usuario buscarUsuarioPorId(Long id) {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getId().equals(id)) return jugadores.get(i);
        }
        return null;
    }

    public boolean verficarSiLaRondaEstaIniciado() {
        return rondas.isEmpty() || obtenerRondaActual().validarSiLaRondaTermino();
    }

    public List<Usuario> obtenerJugadoresEnLaPartida(){
        return jugadores;
    }

    public Integer getCantidadDejugadores() {
        return cantidadDejugadores;
    }

    public void setCantidadDejugadores(Integer cantidadDejugadores) {
        this.cantidadDejugadores = cantidadDejugadores;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public List<Usuario> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Usuario> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(List<Ronda> rondas) {
        this.rondas = rondas;
    }

    public void setEquipoGanador(Equipo equipo) {
        this.equipoGanador= equipo;
    }

    public Equipo getEquipoGanador() {
        return equipoGanador;
    }
}