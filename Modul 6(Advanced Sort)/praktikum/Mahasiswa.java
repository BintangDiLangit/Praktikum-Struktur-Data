/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak6;

class Mahasiswa {

    private long nim;
    private String nama;

    public Mahasiswa(long nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public void displayMhs() {
        System.out.print("\tNim = "+ nim+" ");
        System.out.print(", Nama = "+ nama+" ");
        System.out.println();
    }

    public long getNim() {

        return nim;

    }

    public String getNama() {
        return nama;
    }
}
