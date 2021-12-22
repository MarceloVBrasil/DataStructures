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
public class LinkedList<E> {
    private class Node<E>{
        // instance variables of Node: value and a pointer to the next node
        private E value;
        private Node next;
        
        private Node(E value){
            this.value = value;
            this.next = null;
        }
    }
    // instance variables of Linked List: a pointer to the head node and a pointer to the tail node
    private Node head;
    private Node tail;
    /**
     * Creates Linked List
     */
    public LinkedList(){
        head = tail = null;
    }
    /**
     * Add node at the head of list
     * @param value 
     */
    public void add(E value){
        Node newNode = new Node(value);
        if(head == null){
            head = tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }
    /**
     * Add node at the tail of list
     * @param value 
     */
    public void addTail(E value){
        Node newNode = new Node(value);
        if(head == null)
            head = tail = newNode;
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    /**
     * Add node after a given index
     * @param value
     * @param index 
     */
    public void addAfter(E value,int index){
        Node newNode = new Node(value);
        Node previous = head;
        for(int i = 0; i < index; i++){
            previous = previous.next;
        }
        // new node at the tail
        if(previous.next == null){
            tail = newNode;
        }
        // all other cases
        newNode.next = previous.next;
        previous.next = newNode;
    }
    /**
     * Deletes head node
     * @return head node value
     * @throws datastructures.EmptyException
     */
    public E delete() throws EmptyException{
        Node deletedNode = head;
        if(isEmpty())
            throw new EmptyException("Empty Linked List. Cannot delete");
        if(head == tail)
            head = tail = null;
        else
            head = head.next;
        return (E) deletedNode.value;
    }
    /**
     * Delete tail node
     * @return tail node value
     * @throws datastructures.EmptyException
     */
    public E deleteTail() throws EmptyException{
        if(isEmpty())
            throw new EmptyException("Empty Linked List. Cannot delete");
        Node deletedNode = tail;
        Node current = head;
        while(current.next != tail)
            current = current.next;
        tail = current;
        tail.next = null;
        return (E) deletedNode.value;
    }
    /**
     * Delete node after given index
     * @return deleted node value
     * @param index
     */
    public E deleteAfter(int index) throws EmptyException{
        if(isEmpty()){
            throw new EmptyException("Empty list. Cannot delete");
        }
        if(index >= this.size()){
            throw new IndexOutOfBoundsException("index must be less than " + this.size());
        }
        Node previous = head;
        for(int i = 0; i < index; i++)
            previous = previous.next;
        Node deletedNode = previous.next;
        // if tail is to be deleted
        if(previous.next == tail){
            tail = previous;
            tail.next = null;
        }
        // any other case
        else
            previous.next = previous.next.next;
        return (E) deletedNode.value;
    }
    /**
     * Checks if list is empty
     * @return true if list is empty 
     */
    public boolean isEmpty(){
        return head == null;
    }
    /**
     * prints list
     */
    public void printLinkedList() throws EmptyException{
        if(isEmpty()){
            throw new EmptyException("Empty list. Cannot print");
        }
        Node current = head;
        while(current != null){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println("");
    }
    /**
     * Calculates list size
     * @return size
     */
    public int size(){
        Node current = head;
        int size = 0;
        while(current != null){
            current = current.next;
            size++;
        }
        return size;
    }
}
