/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Manuel Esteban
 */
public class Asiento {
    private char letra;
    private int numero;
    private boolean disponibilidad;

    public Asiento(char letra, int numero, boolean disponibilidad) {
        this.letra = letra;
        this.numero = numero;
        this.disponibilidad = disponibilidad;
    }

    public char getLetra() {
        return letra;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
}
