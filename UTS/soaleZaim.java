/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS;
import java.util.*;


class Warga {

    private String KK;
    private int jml_anggota;
    private String alamat;
    private int norumah;

    public Warga(
            String KK, int jml_anggota, String alamat, int norumah
    ) {
        this.KK = KK;
        this.jml_anggota = jml_anggota;
        this.alamat = alamat;
        this.norumah = norumah;

    }

    public String getKK() {
        return KK;
    }

    public int getAnggota() {
        return jml_anggota;
    }

    public String getAlamat() {
        return alamat;
    }

    public int getNorumah() {
        return norumah;
    }

}

class wargaApp {

    private Warga[] warga;
    public int nElemen;

    public wargaApp(int max) {
        warga = new Warga[max];
        nElemen = 0;
    }

    public void insert(
            String KK,
            int jml_anggota,
            String alamat,
            int norumah
    ){
        if (ceknamakk(KK)) {
            System.out.println(KK+" Sudah terdaftar");
            System.out.println(
            "Kepala keluarga: "+KK+
            ", Anggota: "+jml_anggota+
            ", Alamat: "+alamat+
            ", No. Rumah"+norumah
            );
        }else{
            warga[nElemen]=new Warga(KK,jml_anggota, alamat, norumah);
            nElemen++;
        }
    }
    public boolean ceknamakk(String KK){
        for (int i = 0; i < nElemen; i++) {
            if (KK==warga[i].getKK()) {
                return true;
            }
        }
        return false;
    }
    public void display(){
        int no=1;
        for (int i = 0; i < nElemen; i++) {
            System.out.println(
            no++ +"."+
            "Kepala keluarga: "+warga[i].getKK()+
            ", Anggota: "+warga[i].getAnggota()+
            ", Alamat: "+warga[i].getAlamat()+
            ", No. Rumah: "+warga[i].getNorumah()
            
            );
        }
    }

    public void MergeSort() {
        System.out.println("===================Sorting==================");
        Warga[] workSpace = new Warga[nElemen];
        recMergeSort(workSpace, 0, nElemen - 1);
    }

    public void recMergeSort(Warga[] workSpace, int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(workSpace, lowerBound, mid);
            recMergeSort(workSpace, mid + 1, upperBound);
            merge(workSpace, lowerBound, mid + 1, upperBound);

        }

    }

    public void merge(Warga[] workSpace, int lowIndex, int highIndex, int upperBound) {
        int j = 0;
        int lowerBound = lowIndex;
        int mid = highIndex - 1;
        int nElemen = upperBound - lowerBound + 1;

        while (lowIndex <= mid && highIndex <= upperBound) {
            if (warga[lowIndex].getKK().compareTo(warga[highIndex].getKK()) < 0) {
                workSpace[j++] = warga[lowIndex++];
            } else {
                workSpace[j++] = warga[highIndex++];
            }
        }
        while (lowIndex <= mid) {
            workSpace[j++] = warga[lowIndex++];
        }
        while (highIndex <= upperBound) {
            workSpace[j++] = warga[highIndex++];
        }
        for (j = 0; j < nElemen; j++) {
            warga[lowerBound + j] = workSpace[j];
        }
    }
    public void swap(int one,int two){
        Warga temp =warga[one];
        warga[one]=warga[two];
        warga[two]=temp;
    }
    public int jumlahkpldananggota(int n){
        if (n-1<0) {
            return 0;
        }else{
            return(warga[n-1].getAnggota()+1)+jumlahkpldananggota(n-1);
        }//+1 untuk menghitung KK nya juga
    }
    public int binarySearch(int bb, int ba, String key) {
       while(bb<=ba){
           int mid=bb+(ba-bb)/2;
           if (warga[mid].getKK().compareTo(key)==0) 
               return mid;
           
           else if (warga[mid].getKK().compareTo(key)>0) {
               ba = mid-1;
               binarySearch(bb, ba, key);
           }
           else if (warga[mid].getKK().compareTo(key)<0) {
               bb = mid+1;
               binarySearch(bb, ba, key);
           }
           else{
               return -1;
           }
       }
       return -1;
    }
}

public class No2 {
    public static void main(String[] args) {
        wargaApp w = new wargaApp(100);
        w.insert("Sarip", 5, "JL. Karangkunci", 3);
        w.insert("Indi", 3, "JL. Klampok", 5);
        w.insert("Bima", 7, "JL. Sidomukti", 7);
        w.insert("Fahmi", 15, "JL. Bungkuk", 9);
        w.insert("Juna", 5, "JL. Bungkuk", 3);
        w.insert("Farouq", 3, "JL. Bungkuk", 5);
        w.insert("Ami", 7, "JL. Bungkuk", 7);
        w.insert("Ali", 15, "JL. Gondang", 9);
        w.insert("Ardi", 7, "JL. Bedali", 7);
        w.insert("Pandu", 15, "JL. Jakarta", 9);
        w.display();

        w.MergeSort();
        w.display();
        String kond = "y";
        Scanner input = new Scanner(System.in);
        
        while(kond.equals("y")){
        System.out.println("Cari Data = ");
        String key = input.next();
        int find = w.binarySearch(0, w.nElemen-1 ,key);
        if (find==-1) {
            System.out.println(key + " Tidak ditemukan");
        }else{
            System.out.println(key+" Ditemukan di index "+find);
        }
        System.out.println("Pencarian lagi?(y/t)");
        kond = input.next();
        }
        System.out.println("Jumlah warga: "+w.jumlahkpldananggota(4));
    }
}
 
