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
public class Cliente extends Usuario{
    private Asiento asiento;
    private Sala sala;
    private Funcion funcion;
    

    public Cliente(String nombre, int edad, int documento) {
        super(nombre, edad, documento);

        this.asiento = null;
        this.sala = null;
        this.funcion = null;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public Sala getSala() {
        return sala;
    }

    public Funcion getFuncion() {
        return funcion;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }
    
    
    
}
