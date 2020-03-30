/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum_8;

/**
 *
 * @author str5
 */
class Data2 {

    private int data;

    public Data2(int data) {
        this.data = data;
    }

    public int getKey() {
        return data;
    }
}

class HashTable2 {

    private Data2[] hashArray;
    private int size;

    public HashTable2(int size) {
        this.size = size;
        hashArray = new Data2[size];
    }

    public void displayTable() {
        System.out.println("Table: ");
        for (int i = 0; i < size; i++) {
            if (hashArray[i] != null) {
                System.out.println(" | " + i + "\t | " + hashArray[i].getKey() + " |");
            } else {
                System.out.println(" | " + i + "\t | -- |");
            }
        }
        System.out.println("");
    }

    public int hashFunc(int key) {
        return key % size;
    }


    public void insert(int data) {
        Data2 item = new Data2(data);
        int key = item.getKey();
//        int x = hashFunc(key);

        int hashVal = hashFunc(key);
        int num = 0;
        while (hashArray[hashVal]!=null) {            
            num++;
            hashVal = (hashVal+(num*num))%size;
        }
        hashArray[hashVal]=item;
    }
    public Data2 delete(int key){
        int hashVal = hashFunc(key);
        int num = 0;
        while (hashArray[hashVal]!=null) {            
            if (hashArray[hashVal].getKey()==key) {
                Data2 temp = hashArray[hashVal];
                hashArray[hashVal]=null;
                return temp;
            }else{
                num++;
                hashVal = (hashVal+(num*num))%size;
            }
        }
        return null;
    }
    public Data2 find(int key){
        int hashVal = hashFunc(key);
        int num = 0;
        while (hashArray[hashVal]!=null) {            
            if (hashArray[hashVal].getKey()==key) {
                return hashArray[hashVal];
            }else{
                num++;
                hashVal = (hashVal+(num*num))%size;
            }
        }
        return null;
    }
}
    

    public class nim_genap {

        public static void main(String[] args) {
            HashTable2 h = new HashTable2(10);
            h.insert(10);
            h.insert(10);
            h.insert(10);
            h.insert(12);
            h.insert(12);
            h.insert(12);
            h.insert(129);
            
            h.displayTable();
            h.delete(10);
            h.displayTable();
            int key=12;
            
            if (h.find(key)!=null) {
                System.out.println(key+" Ketemu");
            }else{
                System.out.println(key+" Gak ketemu pehhh");
            }
           
            
            
        }
    }
