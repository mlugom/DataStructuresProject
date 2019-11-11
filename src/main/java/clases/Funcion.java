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
    private Fecha fecha;
    private int hora;
    private Sala sala;
    private Asiento[][] asientos;

    public Funcion(Pelicula pelicula, Fecha fecha, int hora, Sala sala) {
        this.pelicula = pelicula;
        this.fecha = fecha;
        this.hora = hora;
        this.sala = sala;
        this.asientos = new Asiento[3][7]; 
        for(int i=0;i<asientos.length;i++){
            for(int j=0;j<asientos[i].length;j++){
                asientos[i][j]= new Asiento((char)(i+65),j,true);
            }
        }
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Fecha getFecha() {
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

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }
    
    public void ocuparAsiento(int i, int j){
        this.asientos[i][j].setDisponibilidad(false);
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }
    
    
    
}
