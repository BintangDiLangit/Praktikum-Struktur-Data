/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortuniv;
import java.util.Scanner;

/**
 *
 * @author BintangDiLangit
 */
public class QuickSortUNIV {

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    String kata; 
    char kataChar[];
    char huruf;

    public QuickSortUNIV(char[] kataChar, String kata) 
    {
        this.kataChar = kataChar; 
        this.kata = kata; 
    }

    public void display()
    {
        for (int i = 0; i < kataChar.length; i++)
        {
            System.out.print(kataChar[i] + " ");
        }

    }

    public void QuickSort() {
        recQuickSort(0, kataChar.length - 1); 
    }

    private void recQuickSort(int batasKiri, int batasKanan) 
    {
        if (batasKanan - batasKiri <= 0)
        {
            return;
        } else {
            char pivot = kataChar[batasKanan]; 
            int partisi = partitionIt(batasKiri, batasKanan, pivot);
            recQuickSort(batasKiri, partisi - 1);
            recQuickSort(partisi + 1, batasKanan);
        }
    }

    public int partitionIt(int batasKiri, int batasKanan, char pivot) {
        int indexKiri = batasKiri - 1;
        int indexKanan = batasKanan;
        while (true) {
            while (indexKiri < batasKanan && kataChar[++indexKiri] < pivot) ;
            while (indexKanan > batasKiri && kataChar[--indexKanan] > pivot) ;
            if (indexKiri >= indexKanan) {
                break;
            } else {
                swap(indexKiri, indexKanan);
            }
        }
        swap(indexKiri, batasKanan);
        return indexKiri;
    }

    public void swap(int one, int two) {
        char temp;
        temp = kataChar[one];
        kataChar[one] = kataChar[two];
        kataChar[two] = temp;
    }

    public void getHuruf() {
        Scanner sc = new Scanner(System.in);
        String hurufStr;
        System.out.println("");
        System.out.print("Masukkan kata yang dicari:");
        hurufStr = sc.nextLine();
        if (hurufStr.length() == 1) 
        {
            huruf = hurufStr.charAt(0);
            System.out.println("ada " + getJumlah() + " pada " + kata);
        } else {
            System.out.println("Insert 1 Huruf");
        }
    }

    public int getJumlah() 
    {
        int sum = 0;
        for (int i = 0; i < kataChar.length; i++) 
        {
            if (kataChar[i] == huruf) {
                sum++;
            }
        }
        return sum;
    }
}



