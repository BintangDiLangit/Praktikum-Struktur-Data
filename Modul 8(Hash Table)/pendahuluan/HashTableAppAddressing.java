/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendahuluan_prak_8;

/**
 *
 * @author BintangDiLangit
 */
class Data {

    private int Data;

    public Data(int data) {
        this.Data = data;
    }

    public int getKey() {
        return Data;
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
        Data item = new Data(data);
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            ++hashVal;
            hashVal %= size;
        }
        hashArray[hashVal] = item;
    }

    public Data delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                Data temp = hashArray[hashVal];
                hashArray[hashVal] = null;
                return temp;
            }
            ++hashVal;
            hashVal %= size;
        }
        return null;
    }

    public Data find(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= size;
        }
        return null;
    }
}

public class HashTableAppAddressing {

    public static void main(String[] args) {
        int size = 10;
        HashTable h = new HashTable(size);
        h.insert(10);
        h.insert(10);
        h.insert(10);
        h.insert(13);
        h.insert(18);
        h.insert(15);
        h.insert(11);
        h.insert(19);
        h.insert(17);
        h.insert(12);

//        h.insert(18);
//        h.insert(25);
//        h.insert(28);
//        h.insert(36);
//        h.insert(10);
        
        h.displayTable();
        int key = 26;
        if (h.find(key) != null) {
            System.out.println(key + " ketemu");
        } else {
            System.out.println(key + " gak ketemu");
        }
    }
}
