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
public class DoublyLinkListApp {
    public static void main(String[] args) {
       DoublyLinkList theList=new DoublyLinkList();
       theList.insertFirst(19001, 90);
       theList.insertFirst(19002, 85);
       theList.insertFirst(19004, 95);
       theList.insertFirst(19003, 80);
       theList.insertFirst(19006, 70);
       theList.insertFirst(19007, 100);
       theList.insertFirst(19008, 75);
       
       
       theList.displayForward();
       theList.sortList();
       theList.displayForward();
       System.out.println("Jumlah list="+theList.getCount());
        System.out.println("Jumlah Score= "+theList.getJmlScore());
        System.out.println("Rata-Rata = "+ theList.ratarata());
      theList.median();
     theList.kuartil1();
      theList.kuartil2();
    }
    
    
}
