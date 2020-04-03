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
class LinkedList { //awal class LinkedList dengan diawali mendeklar frist dan LinkedList. dan mengisi first dengan null
 
    public ObjekData first; // pendeklarasian variable objek
    public LinkedList() {  // method container
        first = null; // link mulai dari null atau awal
    } 
 
    public boolean isEmpty() { //methos isEmpty yaitu untuk mengetahui kosong atau tidak, dengan mengembalikan nilai first yang sama dengan null
        return (first == null);  // data pertama 0 maka smua data kosong
    } 
 
    public void insertFirst(long NIM, double score) { // method insert first untuk menambahkan data
        ObjekData newLink = new ObjekData(NIM,score); // deklla
        newLink.next = first;  // insert data dari awal...dan awal akan terus bertambah
        first = newLink; // proses pemasukkannya
    }
 
    public void displayList() { // method list untuk menampilkan data list
        System.out.println("Daftar Nilai Mahasiswa:"); 
        ObjekData current = first;  // pendeklarasian first untuk looping
        while (current != null) { // data bukan null
            current.display();  // method display dari class objek dipanggil
            current = current.next; // link di next...agar terpanggil data selanjutnya
        } 
        System.out.println(""); 
    } 
    
    public void displaylulus(){//untuk menampilkan data yang lulus
        System.out.println("Daftar Nilai Mahasiswa yang >= 70");
        ObjekData current = first; // pendeklarasian first untuk looping
        while (current != null) { // data bukan null
            current.lulus(); // method lulus dari class objek dipanggil
            current = current.next; // link di next...agar terpanggil data selanjutnya
        } 
        System.out.println(""); // untuk enter
   }
    
   public void displayjuara(){//untuk menampilkan data yang 5 besar
        System.out.println("Daftar Nilai Mahasiswa Rank 5 besar:"); 
        ObjekData current = first; // pendeklarasian first untuk looping
        int i = 5; // deklarasi untuk looping
        for (i = 0; i < 5; i++) { // melooping data 5 kali teratas
           current.juara(); // method juara dari class objek dipanggil
           current=current.next; //l ink di next...agar terpanggil data selanjutnya
       }
        System.out.println(""); // untuk enter
   }
    
    public void sortList() {  //untuk mengurutkan data yang kali ini mengurutkan score
        ObjekData current = null, index = null;  // deklarasi untuk loop di sortnya
        int temp;  
       
        if(first == null) {  // jika ksong
            return;  // ya wes gaada yang dirutkan, return saja
        }  
        else {  // selain itu
            
            for(current = first; current.next != null; current = current.next) {  // looping untuk isi smua list
               
                for(index = current.next; index != null; index = index.next) {  // looping untuk isi smua index list atau pointer
                     
                    if(current.score < index.score) {  // jika data < score maka 
                        temp = (int) current.score;  // temp = score nya
                        current.score = index.score;  // lalu current = index
                        index.score = temp;  // dan data dimasukkan ke temp
                    }  
                }  
            }  
        }
    }
   
}  

        
