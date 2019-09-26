/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.util.*;

/**
 *
 * @author Manuel Esteban
 */
public class Funcion {
    private Pelicula pelicula;
    private Date fecha;
    private int hora;
    private Sala sala;

    public Funcion(Pelicula pelicula, Date fecha, int hora, Sala sala) {
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getHora() {
        return hora;
    }

    public Sala getSala() {
        return sala;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    
    
}
