/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utsrank;

/**
 * @author BintangDiLangit
 *
 */
public class ObjekData {        //awal dari class ObjeckData, pada class ini akan di deklar NIM, score, next, previous
   private long NIM; // deklarasi NIM 
   double score; // deklarasi score
   ObjekData next; // deklarasi link
   ObjekData previous; // deklarasi link
   
   public ObjekData(long NIM, double score){// method ObjekData dengan parameter NIM, dan score. memanggil NIM dan score
       this.NIM=NIM; // container
       this.score=score; // container
   }
   public void display(){ //method display untuk menampilkan data/list
       System.out.println(NIM+", Score "+score); // menampilkan data dari object
   }
   
   public void lulus(){// untuk menentukan yang lebih dari 70
       if (score>=70) { // syarat lulus diatas 70
           System.out.println(NIM+", Score "+score); // print nilai yang diatas 70
       }
   }
   
   public void juara(){// untuk menentukan yang 5 besar
       if (score>0) { // 0 karena 5 besar mungkin saja nilainya jelek2
           System.out.println(NIM+", Score "+score); // print nilai 5 besar
       }
   }
   
}
