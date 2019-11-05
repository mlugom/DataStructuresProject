/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

/**
 *
 * @author manuel
 */
public class ChainNode<S> {
    private S element;
    private ChainNode<S> next;

    public ChainNode(S element, ChainNode<S> next) {
        this.element = element;
        this.next = next;
    }

    public ChainNode() {
        this(null,null);
    }
    
    public ChainNode(S element) {
        this(element,null);
    }

    public S getElement() {
        return element;
    }

    public ChainNode<S> getNext() {
        return next;
    }

    public void setElement(S element) {
        this.element = element;
    }

    public void setNext(ChainNode<S> next) {
        this.next = next;
    }
    
    public boolean hasNext(){
        return this.next != null;
    }
}
