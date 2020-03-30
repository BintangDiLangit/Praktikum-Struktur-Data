/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum_5;


public class eksponen {
    private int expo(int base,int expo){
        if (expo==0) {
            return 1;
        }
        return base*expo(base, expo-1);
    }
    public static void main(String[] args) {
        eksponen e=new eksponen();
        System.out.println(e.expo(3, 3)); 
    }
}
