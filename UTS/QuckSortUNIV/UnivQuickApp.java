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
public class UnivQuickApp {

    public static void main(String[] args) {
        String kata;
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan Kata:");
        kata = sc.nextLine();

        char[] kataCh = new char[kata.length()];
        for (int i = 0; i < kata.length(); i++) 
        {
            kataCh[i] = kata.charAt(i);
        }

        QuickSortUNIV f = new QuickSortUNIV(kataCh,kata);
        f.QuickSort();
        f.display();
        while (true) 
        {
            f.getHuruf();
        }

    }

}
