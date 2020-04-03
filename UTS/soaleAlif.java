/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTS;

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
    private int nElemen;

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
    public void BubbleSort(){
        System.out.println("=========Diurutkan berdasarkan No. Rumah===========");
        int batas,i;
        for (batas = nElemen-1; batas > 0; batas--) {
            for (i = 0; i < batas; i++) {
                if (warga[i].getNorumah()>warga[i+1].getNorumah()) {
                    swap(i, i+1);
                }
            }
        }
        display();
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
}

public class No2 {
    public static void main(String[] args) {
        wargaApp w = new wargaApp(100);
        w.insert("Sultan", 5, "JL.Dinoyo", 3);
        w.insert("Idris", 3, "JL.Uwu", 5);
        w.insert("Bintang", 7, "JL.Pare-Wates", 7);
        w.insert("Fahrezi", 15, "JL.OIOI", 9);
        w.display();
        w.BubbleSort();
        
        System.out.println(w.jumlahkpldananggota(4));
    }
}
