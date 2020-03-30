/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendahuluan_prak_4;

class Link {

    public int Data;
    public Link next;

    public Link(int Data) {
        this.Data = Data;
    }

    public void displayLink() {
        System.out.println(Data + " ");
    }
}

class LinkedList {

    private Link first = null;

    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(int Data) {
        Link newLink = new Link(Data);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public Link find(int key) {
        Link current = first;
        while (current.Data != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }
        return current;
    }

    public Link delete(int key) {
        Link current = first;
        Link previous = first;
        while (current.Data != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    public void displaList() {
        System.out.println("List(first --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public void insertLast(int value) {
        Link new_node = new Link(value);

        /* 4. If the Linked List is empty, then make the 
           new node as head */
        if (first == null) {
            first = new Link(value);
        return; 
//        theList.insertFirst(44);
//        theList.insertFirst(66);
//        theList.insertFirst(88);
//        theList.displaList();
//
//        while (!theList.isEmpty()) {
//            Link aLink = theList.deleteFirst();
//            System.out.print("Deleted ");
//            aLink.displayLink();
//            System.out.println("");
//        }
//        theList.displaList();
//
//        theList.insertFirst(33);
//        theList.insertFirst(55);
//        theList.insertFirst(77);
//        theList.insertFirst(88);
        }

        /* 4. This new node is going to be the last node, so 
         make next of it as null */
        new_node.next = null;

        /* 5. Else traverse till the last node / melintasi lainnya sampai last node*/
        Link last = first;
        while (last.next != null) {
            last = last.next;
        }

        /* 6. Change the next of last node */
        last.next = new_node;
//    return; 
    }

    public Link removeLastNode() {
        if (first == null) {
            return null;
        }

        if (first.next == null) {
            return null;
        }

        // Find the second last node 
        Link second_last = first;
        while (second_last.next.next != null) {
            second_last = second_last.next;
        }

        // Change next of second last 
        second_last.next = null;

        return first;
    }

    
}

public class LinkedListApp {

    public static void main(String[] args) {
        LinkedList theList = new LinkedList();

//        theList.insertFirst(22);
//        theList.insertFirst(44);
//        theList.insertFirst(66);
//        theList.insertFirst(88);
//        theList.displaList();
//
//        while (!theList.isEmpty()) {
//            Link aLink = theList.deleteFirst();
//            System.out.print("Deleted ");
//            aLink.displayLink();
//            System.out.println("");
//        }
//        theList.displaList();
//
//        theList.insertFirst(33);
//        theList.insertFirst(55);
//        theList.insertFirst(77);
//        theList.insertFirst(88);
        theList.insertLast(99);
        theList.insertLast(88);
        theList.insertLast(77);

        theList.displaList();

        Link f = theList.find(77);
        if (f != null) {
            System.out.println("ketemu..." + f.Data);
        } else {
            System.out.println("link tidak ditemukan");
        }

        Link d = theList.delete(88);
        if (d != null) {
            System.out.println("hapus link dengan key " + d.Data);
        } else {
            System.out.println("link tidak ditemukan");
        }
        theList.displaList();
        theList.removeLastNode();
        theList.displaList();
    }
}
