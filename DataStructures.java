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
public class DataStructures {

    /**
     * @param args the command line arguments
     */
    static int smallSet  =   1000;
    static int mediumSet =  10000;
    static int largeSet  = 100000;
    public static void main(String[] args) {
        // Small Set
        Stack stack = new Stack();
        long elapsedTime = System.nanoTime();
        for(int i = 0; i < smallSet; i++){
            stack.push(i);
        }
        for(int i = 0; i < smallSet; i++){
            try{
                stack.pop();
            }catch(EmptyException e){
                e.getMessage();
            }
        }
        elapsedTime = System.nanoTime() - elapsedTime;
        System.out.format("Stack (ST): %26d ns %n", elapsedTime);
        
        Queue queue = new Queue();
        elapsedTime = System.nanoTime() - elapsedTime;
        for(int i = 0; i < smallSet; i++){
            queue.enqueue(i);
        }
        for(int i = 0; i < smallSet; i++){
            try{
                queue.dequeue();
            }catch(EmptyException e){
                e.getMessage();
            }
        }
        elapsedTime = System.nanoTime() - elapsedTime;
        System.out.format("Queue (ST): %26d ns %n", elapsedTime);
        
        LinkedList list = new LinkedList();
        elapsedTime = System.nanoTime() - elapsedTime;
        for(int i = 0; i < smallSet; i++){
            list.add(i);
        }
        for(int i = 0; i < smallSet; i++){
            try{
                list.delete();
            }catch(EmptyException e){
                e.getMessage();
            }
        }
        elapsedTime = System.nanoTime() - elapsedTime;
        System.out.format("List  (ST): %26d ns%n", elapsedTime);
        
        DoublyLinkedList dlist = new DoublyLinkedList();
        elapsedTime = System.nanoTime() - elapsedTime;
        for(int i = 0; i < smallSet; i++){
            dlist.add(i);
        }
        for(int i = 0; i < smallSet; i++){
            try{
                dlist.delete();
            }catch(EmptyException e){
                e.getMessage();
            }
        }
        elapsedTime = System.nanoTime() - elapsedTime;
        System.out.format("Doubly List (ST): %20d ns%n", elapsedTime);
        System.out.println("------------------------------------------");
        
        // Medium Set
        elapsedTime = System.nanoTime();
        for(int i = 0; i < mediumSet; i++){
            stack.push(i);
        }
        for(int i = 0; i < mediumSet; i++){
            try{
                stack.pop();
            }catch(EmptyException e){
                e.getMessage();
            }
        }
        elapsedTime = System.nanoTime() - elapsedTime;
        System.out.format("Stack (MT): %26d ns %n", elapsedTime);
        
        elapsedTime = System.nanoTime() - elapsedTime;
        for(int i = 0; i < mediumSet; i++){
            queue.enqueue(i);
        }
        for(int i = 0; i < mediumSet; i++){
            try{
                queue.dequeue();
            }catch(EmptyException e){
                e.getMessage();
            }
        }
        elapsedTime = System.nanoTime() - elapsedTime;
        System.out.format("Queue (MT): %26d ns %n", elapsedTime);
        
        elapsedTime = System.nanoTime() - elapsedTime;
        for(int i = 0; i < mediumSet; i++){
            list.add(i);
        }
        for(int i = 0; i < mediumSet; i++){
            try{
                list.delete();
            }catch(EmptyException e){
                e.getMessage();
            }
        }
        elapsedTime = System.nanoTime() - elapsedTime;
        System.out.format("List  (MT): %26d ns%n", elapsedTime);
        
        elapsedTime = System.nanoTime() - elapsedTime;
        for(int i = 0; i < mediumSet; i++){
            dlist.add(i);
        }
        for(int i = 0; i < mediumSet; i++){
            try{
                dlist.delete();
            }catch(EmptyException e){
                e.getMessage();
            }
        }
        elapsedTime = System.nanoTime() - elapsedTime;
        System.out.format("Doubly List (MT): %20d ns%n", elapsedTime);
        System.out.println("------------------------------------------");
        
        // Large Set
        elapsedTime = System.nanoTime();
        for(int i = 0; i < largeSet; i++){
            stack.push(i);
        }
        for(int i = 0; i < largeSet; i++){
            try{
                stack.pop();
            }catch(EmptyException e){
                e.getMessage();
            }
        }
        elapsedTime = System.nanoTime() - elapsedTime;
        System.out.format("Stack (LT): %26d ns %n", elapsedTime);
        
        elapsedTime = System.nanoTime() - elapsedTime;
        for(int i = 0; i < largeSet; i++){
            queue.enqueue(i);
        }
        for(int i = 0; i < largeSet; i++){
            try{
                queue.dequeue();
            }catch(EmptyException e){
                e.getMessage();
            }
        }
        elapsedTime = System.nanoTime() - elapsedTime;
         System.out.format("Queue (LT): %26d ns %n", elapsedTime);
        
        elapsedTime = System.nanoTime() - elapsedTime;
        for(int i = 0; i < largeSet; i++){
            list.add(i);
        }
        for(int i = 0; i < largeSet; i++){
            try{
                list.delete();
            }catch(EmptyException e){
                e.getMessage();
            }
        }
        elapsedTime = System.nanoTime() - elapsedTime;
         System.out.format("List  (LT): %26d ns%n", elapsedTime);
        
        elapsedTime = System.nanoTime() - elapsedTime;
        for(int i = 0; i < largeSet; i++){
            dlist.add(i);
        }
        for(int i = 0; i < largeSet; i++){
            try{
                dlist.delete();
            }catch(EmptyException e){
                e.getMessage();
            }
        }
        elapsedTime = System.nanoTime() - elapsedTime;
         System.out.format("Doubly List (LT): %20d ns%n", elapsedTime);
        System.out.println("------------------------------------------");
        
    }
}
