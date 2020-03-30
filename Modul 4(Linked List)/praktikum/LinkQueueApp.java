/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum_4;

class LinkQueue {

    int nim;
    public String nama;
    public LinkQueue next;

    public LinkQueue(int nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.next = null;
    }
}

class Queue {

    private LinkQueue front;
    private LinkQueue rear;

    public Queue() {
        
        this.front = this.rear = null;
    }

    public void insert(int nim, String nama) {
        LinkQueue l = new LinkQueue(nim, nama);

        if (this.rear == null) {
            this.front = this.rear = l;
            return;
        }
        this.rear.next = l;
        this.rear = l;
    }

    public LinkQueue remove() {
        if (this.front == null) {
            return null;
        }
        LinkQueue l = this.front;
        this.front = this.front.next;

        if (this.front == null) {
            this.rear = null;
        }
        return l;
    }

    public void displayQueue() {
        System.out.println("Queue (front --> rear: )");
        LinkQueue current = front;
        while (current != null) {
            System.out.println(current.nim + " " + current.nama);
            current = current.next;
        }
        System.out.println("");
    }

}

public class LinkQueueApp {

    public static void main(String[] args) {
        Queue q = new Queue();
        q.insert(1665100, "Dee");
        q.insert(1665200, "Deaja");

        q.displayQueue();
        
        q.insert(1665300, "Ami");
        q.insert(1665400, "Haya");
        q.insert(1665500, "Yati");
        
        q.displayQueue();
        
        q.remove();
        q.remove();
        
        q.displayQueue();
    }
}
