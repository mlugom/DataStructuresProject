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
public class Cola<S> {
    private ChainNode<S> head;
    private ChainNode<S> tail;
    

    public Cola() {
        head = new ChainNode(null);
        tail = new ChainNode(null);
    }
    
    public boolean isEmpty() {
        return head.getNext()==null;
    }

    public S poll() {
        if(this.isEmpty()){
            System.out.println("Cola vacía");
            return null;
        }else{
            ChainNode<S> result = this.head.getNext();
            this.head.setNext(result.getNext());
            return result.getElement();
        }
    }
    
    public S peek(){
        if(this.isEmpty()){
            System.out.println("Cola vacía");
            return null;
        }else{
            return this.head.getNext().getElement();
        }
    }

    public void add(S theElement) {
        ChainNode<S> nodo = new ChainNode((S) theElement,null);
        if(this.isEmpty()){
            this.head.setNext(nodo);
            this.tail.setNext(nodo);
        }else{
            
            this.tail.getNext().setNext(nodo);
            this.tail.setNext(nodo);
            
        }
    }
}
