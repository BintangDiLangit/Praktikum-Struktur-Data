/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum_9try2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author BintangDiLangit
 */
class Node {

    private int data;

    public Node(int key) {
        this.data = key;

    }

    public int getKey() {
        return data;
    }

    public void setKey(int id) {
        this.data = id;
    }
}

class Heap {

    private Node[] heapArray;
    private int maxSize;
    private int currentSize;
    private int last;
//    private int size;
//    private int j;

    public Heap(int size) {
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
        last = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];

        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];

        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        int largerChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public void displayHeap() {
        System.out.println("Heap Array: ");
        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].getKey() + " ");
            } else {
                System.out.println("--");
            }
        }
        System.out.println("");
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "..................................";
        System.out.println(dots + dots);
        while (currentSize > 0) {
            if (column == 0) {
                for (int wow = 0; wow < nBlanks; wow++) {
                    System.out.print(' ');
                }
            }
            System.out.print(heapArray[j].getKey());
            if (++j == currentSize) {
                break;
            }
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println("");
            } else {
                for (int uwu = 0; uwu < nBlanks * 2 - 2; uwu++) {
                    System.out.print(' ');
                }
            }
        }
        System.out.println("\n" + dots + dots);
    }

    public void displayArray() {
        for (int i = 0; i < last; i++) {
            System.out.print(heapArray[i].getKey() + " ");
        }
        System.out.println("");
    }

//      public void insertAt(int index, Node newNode) {
//        heapArray[index] = newNode;
//    }
    public void insertKey(int in, int val) {
        Node node = new Node(val);
        heapArray[in] = node;
        currentSize++;
        last++;
    }

//    public void incrementSize() {
//        currentSize++;
//    }
    public void heapSorting() {
        for (int i = last - 1; i >= 0; i--) { // remove from heap and store at array end
            for (int j = last / 2 - 1; j >= 0; j--) { // make random array into heap
                trickleDown(j);
            }
            Node remove = this.remove();
            heapArray[i] = remove;
        }
    }
    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey(); // deklarasi value lama
        heapArray[index].setKey(newValue); // merubah ke baru

        if (oldValue < newValue) { // jika newValuelebih besar
            trickleUp(index); // maka naik
        } else { // jika newValue lebih kecil
            trickleDown(index); // maka turun
        }
        return true;
    }

    public void random() throws IOException {
        int size, j;
        System.out.print("Enter number of items: ");
        size = getInt();
        Heap theHeap = new Heap(size);
        for (j = 0; j < size; j++) {
            int random = (int) (java.lang.Math.random() * 100);
//            Node newNode = new Node(random);
            theHeap.insertKey(j, random);
        }
        System.out.print("Random: ");
        theHeap.displayArray();
        theHeap.displayHeap();
        theHeap.heapSorting();
        theHeap.displayArray();
    }

//    public void randomSort() throws IOException{
//         int size, j;
//        System.out.print("Enter number of items: ");
//        size = getInt();
//        Heap theHeap = new Heap(size);
//        for (j = 0; j < size; j++) {
//            int random = (int) (java.lang.Math.random() * 100);
//            Node newNode = new Node(random);
//            theHeap.insertAt(j, newNode);
//            theHeap.incrementSize();
//        }
//        System.out.print("Random: ");
//        theHeap.displayArray();
//
//        for (j = size / 2 - 1; j > 0; j--) {
//            theHeap.trickleDown(j);
//        }
//        System.out.println("Heap: ");
//        theHeap.displayArray();
//        theHeap.displayHeap();
//
//        for (j = size - 1; j >= 0; j--) {
//            Node biggestNode = theHeap.remove();
//            theHeap.insertAt(j, biggestNode);
//        }
//        System.out.print("Sorted: ");
//        theHeap.displayArray();
//        theHeap.displayHeap();
//    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

}

public class HeapAppSort {

    public static void main(String[] args) throws IOException {
        Heap h = new Heap(32);
//        h.insert(0);
//        h.insert(1);
//        h.insert(2);
//        h.insert(3);
//        h.insert(4);
//        h.insert(5);
//        h.insert(6);
//        h.insert(7);
//        h.insert(8);
//        h.insert(9);
//        h.insert(10);
//        h.insert(11);
//        h.insert(20);

//        h.insertKey(0, 44);
//        h.insertKey(1, 22);
//        h.insertKey(2, 55);
//        h.insertKey(3, 33);
//        h.insertKey(4, 11);
//        h.displayHeap();
//        h.remove();
//        h.change(0, 50);
//        h.displayHeap();
//        h.displayArray();
//        
//        
//        System.out.println("==============");
//        h.heapSorting();
//        h.displayHeap();
//        h.displayArray();
        h.random();
        h.heapSorting();
    }

}
