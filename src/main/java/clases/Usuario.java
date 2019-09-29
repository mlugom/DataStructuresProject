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
public class Usuario {
    
    protected String nombre;
    protected int edad;
    protected int documento;
    protected boolean rol;


  
    public Usuario(String nombre, int edad, int documento) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
        this.rol = rol;

    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public boolean isRol() {
        return rol;
    }

    public void setRol(boolean rol) {
        this.rol = rol;
    }
    
    
}
