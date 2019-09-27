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
public class Sala {
   private Funcion funcion;
   private int numSala;
   private Asiento[][] asientos;

    public Sala(int cantAsientos, Funcion funcion, int numSala) {
        this.funcion = funcion;
        this.numSala = numSala;
        this.asientos = new Asiento[3][7]; 
        for(int i=0;i<asientos.length;i++){
            for(int j=0;j<asientos[i].length;j++){
                asientos[i][j]= new Asiento((char)(i+65),int j,boolean true);
                asientos[i][j].setNumero(j);
            }
        }
    }


    public Funcion getFuncion() {
        return funcion;
    }

    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }
    
}
