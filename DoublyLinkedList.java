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
public class DoublyLinkedList<E> {
    private class Node<E>{
        // Instance variables from Node class
        private E value;
        private Node next;
        private Node prev;
        /**
         * Creates a Node
         * @param value
         */
        public Node(E value){
            this.value = value;
            this.next = null;
            this.prev = null;
        }        
    }
    // Instance variables from DoublyLinkedList class
        private Node head;
        private Node tail;
        /**
         * Creates a DoublyLinkedList
         */
        public DoublyLinkedList(){
            head = tail = null;
        }
        /**
         * Adds a new node at the front
         * @param value 
         */
        public void add(E value){
            Node newNode = new Node(value);
            if(isEmpty()){
                head = tail = newNode;
            }
            else{
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }
        /**
         * Adds a new node before a given index
         * @param value 
         * @param index 
         */
        public void addBefore(E value, int index){
            Node newNode = new Node(value);
            Node current = head;
            if(isEmpty() || index == 0){
                this.add(value);
            }
            else{
                // place current node after where new node should be
                for(int i = 0; i < index; i++){
                    current = current.next;
                }
                // link new node to its next
                newNode.next = current;
                // place current BEFORE where new node should be
                current = current.prev;
                newNode.prev = current;
                current.next = newNode;
                // place current AFTER new node
                current = current.next.next;
                current.prev = newNode;
            }
        }
        /**
         * Adds new node after a given index
         * @param value
         * @param index 
         */
        public void addAfter(E value, int index){
            if(isEmpty() || index == this.size() - 1){
                this.addTail(value);
            }
            else{
                Node newNode = new Node(value);
                Node current = head;
                // place current node before new node should be
                for(int i = 0; i < index; i++){
                    current = current.next;
                }
                // link new node to its prev
                newNode.prev = current;
                // place current node AFTER where new node should be
                current = current.next;
                newNode.next = current;
                current.prev = newNode;
                // place current node BEFORE new node
                current = current.prev.prev;
                current.next = newNode;
            }
        }
        /**
         * Adds new node at the tail
         * @param value 
         */
        public void addTail(E value){
            if(isEmpty()){
                this.add(value);
            }
            else{
                Node newNode = new Node(value);
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            }
        }
        /**
         * Deletes node at the head
         * @return deleted node value
         */
        public E delete() throws EmptyException{
            if(!isEmpty()){
                Node deletedNode = head;
                if(head.next == null){
                    head = tail = null;
                }
                else{
                    Node current = head.next;
                    current.prev = null;
                    head = head.next;
                }
                return (E) deletedNode.value; 
            }
            else{
                throw new EmptyException("List is empty. Cannot delete");
            }
        }
        /**
         * Deletes node at a given index
         * @param index
         * @return deleted node value
         */
        public E deleteAt(int index) throws EmptyException{            
           if(!isEmpty()){
               Node deletedNode = head;
               Node current = head;
               if(index == 0){
                   this.delete();
               }
               else if(index == this.size() - 1){
                   this.deleteTail();
               }
               else{
                   // place current node BEFORE node to be deleted
                   for(int i = 0; i < index - 1; i++){
                       current = current.next;
                   }
                   current.next = current.next.next;
                   // place current node AFTER node to be deleted
                   current = current.next;
                   current.prev = current.prev.prev;
               }
               return (E) deletedNode.value;
           }
           else{
               throw new EmptyException("List is empty. Cannot delete");
           }
        }
        /**
         * Deletes node at the tail
         * @return deleted node value
         */
        public E deleteTail() throws EmptyException{
            if(!isEmpty()){
                Node deletedNode = tail;
                Node current = tail.prev;
                current.next = null;
                tail = tail.prev;
                if(tail == null){
                    head = null;
                }
                return (E) deletedNode.value;
            }
            else{
                throw new EmptyException("List is empty. Cannot delete");    
            }            
        }
        /**
         * Gets the size of list
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
        /**
         * print list
         */
        public void showList(){
            Node current = head;
            while(current != null){
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println("");
        }
        /**
         * print reversed list
         */
        public void showReversedList(){
            Node current = tail;
            while(current != null){
                System.out.print(current.value + " ");
                current = current.prev;
            }
            System.out.println("");
        }
        /**
         * Checks if list is empty
         * @return true if list is empty 
         */
        public boolean isEmpty(){
            return head == null && tail == null;
        }
        public void getAllPrev(){
            Node current = head;
            while(current != null){
                if(current.prev == null){
                    System.out.print(" null ");
                }
                else{
                    System.out.print(current.prev + " ");
                }
                current = current.next;
            }
        }
}
