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
class Link {

    private int iData;
    public Link next;
    public Link(int iData){
        this.iData=iData;
    }

    public int getKey() {
        return iData;
    }

    public void displayLink() {
        System.out.print(iData + " | ");
    }
}

class SortedLinkList {

    private Link first;

    public SortedLinkList() {
        first = null;
    }

    public void insert(Link theLink) {
        int key = theLink.getKey();
        Link previous = null;
        Link current = first;
        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = theLink;
        } else {
            previous.next = theLink;
        }
        theLink.next = current;
    }

    public void delete(int key) {
        Link previous = null;
        Link current = first;
        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    public Link find(int key) {
        Link current = first;
        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayList() {
        System.out.print("First --> Last: ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
class HashTable2{
    private SortedLinkList[] hashArray;
    private int size;
    
    public HashTable2(int size){
        this.size=size;
        hashArray = new SortedLinkList[size];
        for (int i = 0; i < size; i++) {
            hashArray[i]=new SortedLinkList();
        }
    }
    public void displayTable(){
        System.out.println("Table: ");
        for (int i = 0; i < size; i++) {
            System.out.print(" "+i+". ");
            hashArray[i].displayList();
        }
    }
    public int hashFunc(int key){
        return key%size;
    }
    public void insert(int data){
        Link theLink = new Link(data);
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }
    public void delete(int key){
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }
    public Link find(int key){
        int hashVal = hashFunc(key);
        Link theLink = hashArray[hashVal].find(key);
        return theLink;
    }
}

public class HashTableAppHashing {
    public static void main(String[] args) {
        int size=15;
        HashTable2 h = new HashTable2(size);
        h.insert(16);
        h.insert(10);
        h.insert(16);
        h.insert(13);
        h.insert(18);
        h.insert(15);
        h.insert(11);
        h.insert(19);
        h.insert(17);
        h.insert(12);
        h.insert(1);

        h.displayTable();
        if (h.find(16)!=null) {
            System.out.println("ketemu");
        }else{
            System.out.println("gak");
        }
    }
}
