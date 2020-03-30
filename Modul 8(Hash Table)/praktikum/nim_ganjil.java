/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum_8;

class Data {

    private int data;

    public Data(int data) {
        this.data = data;
    }

    public int getKey() {
        return data;
    }

}

class HashTable {

    private Data[] hashArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashArray = new Data[size];
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (int i = 0; i < size; i++) {
            if (hashArray[i] != null) {
                System.out.println(" | " + i + "\t | " + hashArray[i].getKey() + " | ");
            } else {
                System.out.println(" | " + i + "\t | -- |");
            }
        }
        System.out.println("");
    }

    public int hashFunc(int key) {
        return key % size;
    }

    public int hashFunc2(int key) {
        return 7 - (key % 7);
    }

    public void insert(int data) {
        Data item = new Data(data);
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int hashVal2 = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            int hashValue = hashVal+hashVal2;
            
            hashVal=hashValue%size;
        }
        hashArray[hashVal] = item;
        
    }

    public Data delete(int key) {
        int hashVal = hashFunc(key);
        int hashVal2 = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Data temp = hashArray[hashVal];
                hashArray[hashVal] = null;
                return temp;
            }
             int hashValue = hashVal+hashVal2;
            
            hashVal=hashValue%size;
        }
        return null;
    }

    public Data find(int key) {
        int hashVal = hashFunc(key);
        int hashVal2 = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            int hashValue = hashVal+hashVal2;
            
            hashVal=hashValue%size;
        }
        return null;
    }

}

public class nim_ganjil {

    public static void main(String[] args) {
        HashTable h = new HashTable(10);
        h.insert(10);
        h.insert(10);
        h.insert(49);
        h.insert(58);
        h.insert(69);
        
        h.displayTable();
        h.delete(14);
        h.displayTable();
        int key = 89;

        System.out.println("Find value = " + key);
        if (h.find(key)!=null) {
            System.out.println("value of " + key + " ketemu woii");
        } else {
            System.out.println("value " + key + " ga ketemu woii");
        }
        h.displayTable();
    }
}
