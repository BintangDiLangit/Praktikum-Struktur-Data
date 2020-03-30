/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum_2;

/**
 *
 * @author BintangDiLangit
 */
public class DataArrayApp {

    public static void main(String[] args) {
        int maxSize = 100;
        DataArray arr = new DataArray(maxSize);
        arr.insert(16650208, "Jundi", "Malang");
        arr.insert(16650202, "Ahmad", "Sidoarjo");
        arr.insert(16650201, "Ismail", "Banyuwangi");
        arr.insert(16650203, "Sofi", "Semarang");
        arr.insert(16650204, "Dinda", "Bandung");
        arr.insert(16650205, "Rais", "Ambon");
        arr.insert(16650200, "Helmi", "Madura");
        arr.insert(16650200, "Agung", "Madiun");
        arr.insert(16650200, "Arina", "Malang");
        arr.displayArray();
        
        arr.bubbleSort();
        System.out.println("=======================");
        arr.displayArray();
        arr.insertionSortbyNim();
        System.out.println("=======================");
        arr.displayArray();
        arr.selectionSortbyName();
        System.out.println("=======================");
        arr.displayArray();

//        long searchKey = 16650270;
//        Mahasiswa mhs = arr.find(searchKey);
//        if (mhs != null) {
//            System.out.print("\nKetemu");
//            mhs.displayMhs();
//        } else {
//            System.out.println("Ga Ketemu " + searchKey);
//        }
//
//        searchKey = 16650240;
//        System.out.println("\nHapus Nim: " + searchKey);
//        arr.delete(searchKey);
//
//        arr.displayArray();
    }
}
