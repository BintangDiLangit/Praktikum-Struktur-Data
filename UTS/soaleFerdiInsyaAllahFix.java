/**
 *
 * @author BintangDiLangit
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Link { //Deklasari class Link

    public Character Data; //Deklasrasi varialbel public Char Data
    public Link next; //Deklasrasi Variabel next tipe Link

    public Link(Character Data) { //Deklarasi method Link dengan nilai Data tipe Char dan pengujian nilai pada variable data.
        this.Data = Data;
    }

    public Character getData() { //Deklarasi method getData dengan tipe Char untuk mengambil data
        return Data;
    }

    public void displayLink() { // Deklarasi method displayLink tipe void 

        System.out.print(Data + " "); // untuk menampilkan data pada program linkedlist

    }
}

class LinkedList { //Deklarasi class baru LinkedList

    private Link first; //Deklarasi Variabel first untuk Head tipe Link
    private Link sorted; //Deklarasi variable Sorted tipe Link

    public LinkedList() { // Deklarasi Method LinkedList
        first = null; //Memberi Nilai null pada variable first
    }

    public boolean isEmpty() { //deklarasi method isEmpty tipe data boolean untuk mengosongkan list
        return (first == null); //mengembalikan nilai first jika bernilai kosong
    }

    public void insertFirst(Character Data) { //Deklarasi method InsertFirst dengan parameter int Data. untuk memasukkan data awal.
        Link newLink = new Link(Data); //memanggil dan memberi nilai method Link untuk memberi nilai pada node dan menggesernya
        newLink.next = first;
        first = newLink;
    }

    public void displayList() { //deklarasi method displayList untuk menampilkan daftar
        Link current = first;  //first current sama dengan data awal pada Link
        while (current != null) { //perulangan saat current tidak sama dengan null
            current.displayLink(); //pernyataan current dari displayLink
            current = current.next; //current adalah current yang selanjutnya

        }
        System.out.println("");
    }

    // berfungsi untuk mengurutkan daftar yang terhubung secara tunggal menggunakan jenis penyisipan
    void insertionSort() {
        // Initialasi sorted linked list
        sorted = null;
        Link current = first;
        // Traverse the given linked list and insert every
        // node to sorted
        while (current != null) {
            // Store next for next iteration
            Link next = current.next;
            // insert current in sorted linked list
            sortedInsert(current);
            // Update current
            current = next;
        }
        // Update head_ref to point to sorted linked list
        first = sorted;
    }

    void sortedInsert(Link newnode) {
        /* Special case for the head end */
        if (sorted == null || sorted.Data.compareTo(newnode.Data) >= 0) {
            newnode.next = sorted;
            sorted = newnode;
        } else {
            Link current = sorted;
            /* Locate the node before the point of insertion */
            while (current.next != null && current.next.Data < newnode.Data) {
                current = current.next;
            }
            newnode.next = current.next;
            current.next = newnode;
        }
    }
}

class Uwu{ //Deklasrasi method mainApp

    private static final int JUMLAH_KARAKTER = 256;
    private static int[] total_per_karakter = new int[JUMLAH_KARAKTER];

    public static void main(String[] args) throws IOException {//main method dari class MainApp
        LinkedList list = new LinkedList(); //membuat variabel List untuk memanggil method pada class sebelumnya
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); //untuk membuat inputan dari keyboard

        System.out.print("Masukkan kata :"); //menampilkan output Masukkan Data
        String kata = input.readLine(); //membaca kata yang dimasukkan

        int size = kata.length(); //panjang dari kata yang diinputkan

        for (int i = 0; i < size; i++) //perulangan i yang merupakan lebih kecil dari size atau panjang data
        {
            list.insertFirst(kata.charAt(i));//memasukkan data yang pertama berdasarkan abjad

        }

        list.insertionSort(); //list memanggil method insertionsort
        System.out.print("alfagram : "); //menampilkan output alfagram
        list.displayList(); //memanggil method displaylist untuk menampilkan data
        // inisialisasikan setiap karakter berjumlah 0 buah
        for (int i = 0; i < JUMLAH_KARAKTER; i++) {
            total_per_karakter[i] = 0;
        }

        // hitung jumlah setiap karakter
        int kata_len = kata.length();
        for (int i = 0; i < kata_len; i++) {
            total_per_karakter[(int) kata.charAt(i)]++;
        }

        // tampilkan jumlah setiap karakter
        System.out.println();
        for (int i = 0; i < JUMLAH_KARAKTER; i++) {
            if (total_per_karakter[i] > 0) {
                if (((char) i >= 'a' && (char) i <= 'z')) {
                    System.out.println("Jumlah huruf " + (char) i + " ada sebanyak " + total_per_karakter[i] + " buah");
                } else if ((char) i >= '0' && (char) i <= '9') {
                    System.out.println("Jumlah angka " + (char) i + " ada sebanyak " + total_per_karakter[i] + " buah");
                } else if ((char) i == ' ') {
                    System.out.println("Jumlah Spasi ada sebanyak " + total_per_karakter[i] + " buah");
                } else {
                    System.out.println("Jumlah karakter " + (char) i + " ada sebanyak " + total_per_karakter[i] + " buah");
                }
            }
        }

        // hitung jumlah kata
        int jumlahKata = 0;
        int i = 0;
        while (i < kata.length()) {
            // abaikan spasi pada awal string dan spasi lebih dari satu
            while (i < kata.length() && kata.charAt(i) == ' ') {
                i++;
            }

            if (i < kata.length() && kata.charAt(i) != ' ') {
                jumlahKata++;
                while (i < kata.length() && kata.charAt(i) != ' ') {
                    i++;
                }
            }
        }

        System.out.println("\nJumlah Kata : " + jumlahKata + " buah");
    }
}
