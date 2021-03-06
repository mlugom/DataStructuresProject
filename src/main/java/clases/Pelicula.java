/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.util.*;
import estructuras.*;
/**
 *
 * @author Manuel Esteban
 */
public class Pelicula {
    private String titulo;
    private int duracion;
    private int edadMinima;
    private DinamicArr<Funcion> funciones;
    private double puntuacion;

    public Pelicula(String titulo, int duracion, int edadMinima, double puntuacion) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.edadMinima = edadMinima;
        this.funciones = new DinamicArr<>();
        this.puntuacion = puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }

    public DinamicArr<Funcion> getFunciones() {
        return funciones;
    }

    public void setFunciones(DinamicArr<Funcion> funciones) {
        this.funciones = funciones;
    }
    
    public void addFuncion(Funcion funcion){
        this.funciones.add(funcion);
    }
    
}
