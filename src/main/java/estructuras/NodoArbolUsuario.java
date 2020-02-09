/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;
import clases.*;

/**
 *
 * @author manuel
 */
public class NodoArbolUsuario {
    private Usuario key;
    private NodoArbolUsuario left;
    private NodoArbolUsuario right;
    private NodoArbolUsuario parent;
    private int height;
    

    public NodoArbolUsuario(Usuario key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 0;
    }
    
    public NodoArbolUsuario(Usuario key, NodoArbolUsuario parent){
        this(key,null,null,parent,0);
    }

    public NodoArbolUsuario() {
        this.key = null;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 0;
    }

    public NodoArbolUsuario(Usuario key, NodoArbolUsuario left, NodoArbolUsuario right, NodoArbolUsuario parent, int height) {
        this.key = key;
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.height = height;
    }

    public Usuario getKey() {
        return key;
    }

    public NodoArbolUsuario getLeft() {
        return left;
    }

    public NodoArbolUsuario getRight() {
        return right;
    }
    
    public NodoArbolUsuario getParent(){
        return parent;
    }

    public void setKey(Usuario key) {
        this.key = key;
    }

    public void setLeft(NodoArbolUsuario left) {
        this.left = left;
    }

    public void setRight(NodoArbolUsuario right) {
        this.right = right;
    }

    public void setParent(NodoArbolUsuario parent) {
        this.parent = parent;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
}
