/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendahuluan_prak_6;

class Mahasiswa{
    private long nim;
    private String nama;
    
    public Mahasiswa(long nim,String nama){
        this.nim=nim;
        this.nama=nama;
        
    }
    public void displaymhs(){
        System.out.print("\t NIM = "+nim);
        System.out.println(", Nama = "+nama);
    }
    public long getNim(){
        return nim;
    }
}
class ShellSort2{
    public Mahasiswa arr[];
    public int nElemen;
    
    public ShellSort2(int max){
    arr = new Mahasiswa[max];
    nElemen=0;
}
    public void ShellSort_2(){
        System.out.println("===============ShellSort==============");
        int in,out;
        Mahasiswa temp;
        int h = 1;
        
        while(h<=nElemen/3)
           h = 3*h+1;
            while(h>0){
                for (out = h; out < nElemen; out++) {
                    temp = arr[out];
                    in=out;
                    
                    while (in>h-1&&arr[in-h].getNim()>=temp.getNim()) {                        
                        arr[in]=arr[in-h];
                        in-=h;
                    }
                    arr[in]=temp;
                    display();
                    System.out.println("=====================================");
                }
                h=(h-1)/3;
            }
        
    }
    public void display(){
        for (int i = 0; i < nElemen; i++) {
            arr[i].displaymhs();
        }
    }
    public void insert(long nim,String nama){
        
        arr[nElemen]=new Mahasiswa(nim,nama);
        nElemen++;
    }
}
public class pendahuluan2 {
    public static void main(String[] args) {
        ShellSort2 s = new ShellSort2(10);
        s.insert(8, "Bintang");
        s.insert(2, "Alan");
        s.insert(0, "Roger");
        s.insert(3, "Umi");
        s.insert(7, "Sasa");
        s.insert(4, "Kacang");
        s.insert(1, "Garuda");
        s.insert(5, "Tiktok");
        s.display();
        s.ShellSort_2();
        s.display();
    }
}
