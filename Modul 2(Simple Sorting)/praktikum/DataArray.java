/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum_2;

/*BintangDiLangit*/

class Mahasiswa {

    private long nim;
    private String nama;
    private String asal;

    public Mahasiswa(long nim, String nama, String asal) {
        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
    }

    public void displayMhs() {
        System.out.print("\tNim: " + nim);
        System.out.print("\tNama: " + nama);
        System.out.println("\tAsal: " + asal);
    }

    public long getNim() {
        return nim;
    }

    public String getNama(){
        return nama;
    }
    public int setNama(){
        String nama="";
        return nama.compareTo(this.nama);
    }
}

public class DataArray {

    private Mahasiswa[] mhs;
    private int nElemen;

    public DataArray(int max) {
        mhs = new Mahasiswa[max];
        nElemen = 0;
    }

    public Mahasiswa find(long searchNim) {
        int i;
        for (i = 0; i < nElemen; i++) {
            if (mhs[i].getNim() == searchNim) {
                break;
            }
        }
        if (i == nElemen) {
            return null;
        } else {
            return mhs[i];
        }
    }

    public void insert(long nim, String nama, String asal) {
        mhs[nElemen] = new Mahasiswa(nim, nama, asal);
        nElemen++;
    }

    public boolean delete(long searchNim) {
        int i;
        for (i = 0; i < nElemen; i++) {
            if (mhs[i].getNim() == searchNim) {
                break;
            }
        }
        if (i == nElemen) {
            return false;
        } else {
            for (int j = i; j < nElemen; j++) {
                mhs[j] = mhs[j + 1];
            }
            nElemen--;
            return true;
        }
    }

    public void displayArray() {
        for (int i = 0; i < nElemen; i++) {
            mhs[i].displayMhs();
        }
    }
    public void bubbleSort(){
        int batas,i;
        for (batas = nElemen-1; batas > 0; batas--) {
            for (i = 0; i < batas; i++) {
                if (mhs[i].getNim()>mhs[i+1].getNim()) {
                    swap(i,i+1);
                }
            }
        }
    }
    
    public void swap(int one,int two){
        
        Mahasiswa temp=mhs[one];
        mhs[one]= mhs[two];
        mhs[two] =temp ;
    }
    public void insertionSortbyNim(){
        int i ,curIn;
        for (curIn = 1; curIn < nElemen; curIn++) {
            Mahasiswa temp = mhs[curIn];
            i = curIn;
            while(i>0 && (mhs[i-1].getNim()>=temp.getNim())){
                mhs[i]=mhs[i-1];
                i--;
            }
            mhs[i]=temp;
        }
    }

    public void selectionSortbyName(){
        int awal,i,min;
        for (awal = 0; awal < nElemen-1; awal++) {
            min = awal;
            for (i = awal; i < nElemen; i++) {
                int compare= mhs[i].getNama().compareTo(mhs[min].getNama());
                if (compare<0) {
                    min=i;
                }
            }
            swap(awal,min);
        }
    }
        public void selectionSortbyNim(){
        int awal,i,min;
        for (awal = 0; awal < nElemen-1; awal++) {
            min = awal;
            for (i = awal; i < nElemen; i++) {
                
                if (mhs[i].getNim()<mhs[i].getNim()) {
                    min=i;
                }
            }
            swap(awal,min);
        }

        }


}
