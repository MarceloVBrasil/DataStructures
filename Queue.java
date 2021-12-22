/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Marcelo Brasil
 */
public class Queue<E> {
    
    private class Node<E>{
        // instance variables of node class: value and pointer to next node
        private E value;
        private Node next;
        
        private Node(E value){
            this.value = value;
            this.next = null;
        }
    }
    // instance variables of queues: two pointers, one to the first node and one to the last
    private Node first;
    private Node last;
    
    /**
     * Creates new Queue
     */
    public Queue(){
        first = last = null;
    }
    /**
     * Inserts new node into queue
     * @param value 
     */
    public void enqueue(E value){
        Node newNode = new Node(value);
        if(last != null)
            last.next = newNode;
        last = newNode;
        if(first == null)
            first = newNode;
    }
    /**
     * Deletes first node
     * @return first node
     * @throws EmptyException 
     */
    public E dequeue() throws EmptyException{
        E firstNode = (E) first.value;
        if(isEmpty())
            throw new EmptyException("Empty Queue. Cannot Dequeue");
        first = first.next;
        return firstNode;
    }
    
    public void peek() throws EmptyException{
        if(isEmpty())
            throw new EmptyException("Empty queue. Cannot peek");
        System.out.println(first.value + " is the first");
    }
    /**
     * Checks if queue is empty
     * @return true if queue i empty 
     */
    public boolean isEmpty(){
        return first == null;
    }
}
