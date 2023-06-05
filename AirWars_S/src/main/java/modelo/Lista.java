/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Gabriel
 */
public class Lista {
    
    protected String id;
    protected Nodo first;
    private Nodo last;
    private int size;
    
    public Lista(String id){
        this.id = id;
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public void add_f(Object d){
        Nodo new_N = new Nodo(d);
        if(this.first == null){
            this.first = new_N;
            this.last = new_N;
        }else{
            this.first.P = new_N;
            new_N.N = this.first;
            this.first = new_N;
        }
        this.size++;
    }
    
    public void add_l(Object d){
        Nodo new_N = new Nodo(d);
        if(this.last == null){
            this.first = new_N;
            this.last = new_N;
        }else{
            new_N.P = this.last;
            this.last.N = new_N;
            this.last = new_N;
        }
        this.size++;
    }
    
    public void delete_f(){
        if(this.first != null){
            Nodo temp = this.first;
            Nodo nextNode = temp.N;

            if(nextNode != null){
                nextNode.P = null;
            }else{
                this.last = null;
            }

            this.first = nextNode;

            temp.N = null;

            this.size--;
        }
    }
    
    public void delete_l() {
        if(this.last != null){
            Nodo temp = this.last;
            Nodo previousNode = temp.P;
            if(previousNode != null){
                previousNode.N = null;
            }else{
                this.first = null;
            }
            this.last = previousNode;

            temp.P = null;

            this.size--;
        }
}
    
    public class Nodo{
        protected Nodo N;
        protected Nodo P;
        protected Object data;
    
        public Nodo(Object d){
            this.N = null;
            this.P = null;
            this.data = d;
        }
        
        
        
        public Nodo get_N(){return this.N;}
        public Nodo get_P(){return this.P;}
        public Object get_Data(){return this.data;}
    }
}
