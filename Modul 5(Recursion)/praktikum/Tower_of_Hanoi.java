/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum_5;

/**
 *
 * @author str5
 */
public class Tower_of_Hanoi {
    static void hanoi(int n,char a,char c,char b){
        if (n==1) {
            System.out.println("Move disk 1 from "+ a +" to "+c);
        return;
        }
        hanoi(n-1,a,b,c);
        System.out.println("Move disk "+ n+" from "+a+" to "+c);
        hanoi(n-1,b,c,a);
    }
    public static void main(String[] args) {
        int n=3;
        hanoi(n,'A','C','B');
    }
}
