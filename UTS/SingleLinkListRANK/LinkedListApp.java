/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utsrank;

/**
 * @author BintangDiLangit
 *
 */
public class LinkedListApp {
    public static void main(String[] args) {
        LinkedList link= new LinkedList(); // pemanggilan class
        
        link.insertFirst(19650055, 99); // pemanggilan insert
        link.insertFirst(19650078, 81); // pemanggilan insert
        link.insertFirst(19650082, 86); // pemanggilan insert
        
        link.displayList(); // pemanggilan displaysmua
        System.out.println("===Tambah lagi===");
        
        link.insertFirst(19650056, 75);
        link.insertFirst(19650071, 79);
        link.insertFirst(19650014, 60);
        link.insertFirst(19650038, 71);
        

        link.displayList();
        System.out.println("===Tambah lagi===");
        
        link.insertFirst(19650031, 97);
        link.insertFirst(19650009, 41);
        link.insertFirst(19650005, 77);
        link.displayList();
        
        System.out.println("Urutan berdasarkan score");
        link.sortList();
        link.displayList();
        System.out.println("tampilkan list dengan nilai >= 70");
        link.displaylulus(); // pemanggilan yang >= 70
        
        System.out.println("tampilkan list dengan niali Rank 5 besar");
        link.displayjuara(); // pemanggilan rank 5 besar
    }
}
