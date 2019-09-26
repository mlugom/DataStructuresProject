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
    
    public Cliente(String nombre, int edad, int documento, boolean rol) {
        super(nombre, edad, documento, rol);
        this.asiento = null;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
    
}
