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
public class Stack<E> {
    /**
     * 
     * @param <E> 
     */
    private class Node<E>{
        // Instance variables of Node class: value of the node and pointer to next node
        private E value;
        private Node next;
        /**
         * Creates new Node
         * @param value 
         */
        public Node(E value){
            this.value = value;
            this.next = null;
        }
    }
    // Pointer to top node
    private Node top;
    /**
     * Creates new Stack
     */
    public Stack(){
      this.top = null;  
    }
    /**
     * Inserts new node into stack
     * @param value 
     */
    public void push(E value){
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }
    /**
     * Deletes top node
     * @return popped node value
     * @throws EmptyException 
     */
    public E pop() throws EmptyException{
        if(isEmpty())
            throw new EmptyException("Empty Stack. Cannot pop out");
        E node = (E) top.value;
        top = top.next;
        
        return node;
    }
    
    public void peek() throws EmptyException{
        if(isEmpty())
            throw new EmptyException("Empty Stack. Cannot peek");
        System.out.println(top.value + " is at the top");
    }
    /**
     * Checks is stack is empty
     * @return true if stack is empty 
     */
    public boolean isEmpty(){
        return top == null;
    }
}
