/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobauts;

/**
 *
 * @author BintangDiLangit
 */
public class ObjekData {
   private long NIM;
   double score;
   ObjekData next;
   ObjekData previous;
   
   public ObjekData(long NIM, double score){
       this.NIM=NIM;
       this.score=score;
   }
   public void display(){
       System.out.println(NIM+", Score "+score);
   }
    
}
