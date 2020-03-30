/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendahuluan_prak_3;

class Stack {

    private int maxSize;
    private long[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long item) {
        stackArray[++top] = item;
//    System.out.println(item);
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void display() {
        int i = top;
        while (i >= 0) {
            System.out.print(stackArray[i]+" ");
            i--;
        }
        System.out.println("");
    }
}

public class StackApp {

    public static void main(String[] args) {
        Stack theStack = new Stack(4);
        System.out.println(">> push some items");
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);
        theStack.display();
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
