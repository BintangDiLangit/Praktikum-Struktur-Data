/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum_3;

class Queue{
    private int maxSize;
    private String queArray[];
    private int front;
    private int rear;
    private int nItems;
    
    public Queue(int size){
        this.maxSize = size;
        queArray = new String[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    public void insert(String value){
        if (isFull()) {
            System.out.println("Maaf "+value+", antrian masih penuh");
        }else{
        queArray[++rear]=value;
        nItems++;System.out.println(value +" masuk antrian");
        }  
    }
    public String remove(){
        String temp = queArray[front];
        queArray[front]="kosong";
        front++;
        if (front==maxSize) {
            front = 0;
        }
        nItems--;
        return temp;
    }
    public String peek(){
        return queArray[front];
    }
    public boolean isEmpty(){
//        System.out.println("antrian kosong");
        return nItems==0;
    }
    public boolean isFull(){
        return nItems==maxSize;
    }
    public int size(){
        return nItems;
    }
    public void display(){
//        int temp = front;
        for (int i = 0; i < queArray.length; i++) {
            System.out.print(queArray[front++]+" ");
            if (front==maxSize) {
                front=0;
            }
        }
        System.out.println("");
//        front=temp;/
    }
            
}
public class QueueApp {
    public static void main(String[] args) {
        Queue theQueue = new Queue(4);
        System.out.println(">> beberapa mulai mengantri");
        theQueue.insert("Andi");
        theQueue.insert("Ahmad");
        theQueue.insert("Satrio");
        theQueue.insert("Afrizal");
        theQueue.insert("Sukran");
        theQueue.insert("Mahmud");
        System.out.println("\n>> isi antrian");
        theQueue.display();
        System.out.println("\n>> satu persatu keluar antrian");
        while(!theQueue.isEmpty()){
            System.out.println(theQueue.remove()+" Keluar dari antrian");
//            theQueue.display();
            System.out.println("");
        }
        
        System.out.println("Antrian kosong");
        System.out.println(theQueue.size()+" Person");
        theQueue.display();
    }
}
