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
    private Funcion funcion;
    

    public Cliente(String nombre, int edad, int documento) {
        super(nombre, edad, documento);

        this.asiento = null;
        this.funcion = null;
        this.rol = false;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }


    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }
    
    
    
}
