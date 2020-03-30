/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum_4;
class stack{
    int id;
    String name;
    stack link;
}
class stackLinkedList{
    stack top;
    
    public stackLinkedList(){
        this.top = null;
    }
    public void push(int id, String name){
        stack s = new stack();

        if (s == null) {
//            System.out.println("Stack penuh !");
            return;
        }
        s.id = id;
        s.name = name;
        
        s.link = top;
        top = s;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public void pop(){
        top = top.link;
    }
    public void display(){
        stack s = top;
        
        System.out.println("Stack(top --> bottom): ");
        while (s!=null) {            
            System.out.print("{"+s.id+", "+s.name+"}");
            System.out.println("");
            
            s= s.link;
            
        }
        System.out.println("");
    }
    
}
public class StackLinkedListApp {
    public static void main(String[] args) {

        stackLinkedList sll = new stackLinkedList();
        
        sll.push(1, "VCD");
        sll.push(2, "TV");
        
        sll.display();
        
        sll.push(3, "kulkas");
        sll.push(4, "PC");
        sll.push(5, "rice cooker");
        sll.push(6, "dispenser");
        
        sll.display();
        
        sll.pop();
        sll.pop();
        
        sll.display();
    }
}
