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

    public NodoArbolUsuario(Usuario key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public NodoArbolUsuario() {
        this.key = null;
        this.left = null;
        this.right = null;
    }

    public NodoArbolUsuario(Usuario key, NodoArbolUsuario left, NodoArbolUsuario right) {
        this.key = key;
        this.left = left;
        this.right = right;
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

    public void setKey(Usuario key) {
        this.key = key;
    }

    public void setLeft(NodoArbolUsuario left) {
        this.left = left;
    }

    public void setRight(NodoArbolUsuario right) {
        this.right = right;
    }
}
