/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendahuluan_prak_3;

class Stack2 {

    private int maxSize;
    private char[] stackArray;
    private int top;

    public Stack2() {
//        maxSize = size;
//        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(String item) {
        maxSize = item.length();
        stackArray = new char[maxSize];
        for (int i = 0; i < item.length(); i++) {
            stackArray[++top] = item.charAt(i);
        }
//        stackArray[++top] = item;
//    System.out.println(item);
    }

//    public long pop() {
//        return stackArray[top--];
//    }
//
//    public long peek() {
//        return stackArray[top];
//    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void display() {
        System.out.println(">>dibalik jadi...");
        int i = top;
        while (i >= 0) {
            System.out.print(stackArray[i]+"");
            i--;
        }
        System.out.println("");
    }
    public void display(String item){
        System.out.println(">> Katanya...");
        System.out.println(item);
        this.display();
    }
    public void display(long item,String a){//method /constractor dengan 2 parameter
    
    }
}

public class StackApp2 {

    public static void main(String[] args) {
        Stack2 theStack = new Stack2();
        System.out.println(">> push some items");
        String input = "apagitu";
        theStack.push(input);
        theStack.display(input);
//        theStack.display();
//        theStack.push(40);
//        theStack.push(60);
//        theStack.push(80);
//        System.out.println("\n>> peek items in the stack");
//        System.out.println("\n>> pop items in the stack");


//        System.out.println(theStack.pop());
//        theStack.display();
//        System.out.println("=============");
//        System.out.println(theStack.peek());
        
//        while (!theStack.isEmpty()) {
//            long value = theStack.pop();
//            System.out.println(value + " ");
//
//        }
        System.out.println(theStack.isEmpty());
        System.out.println(theStack.isFull());
    }
}
