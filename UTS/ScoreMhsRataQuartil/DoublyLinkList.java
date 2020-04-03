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
public class DoublyLinkList {
   private ObjekData first;
   private ObjekData last;
   
   public DoublyLinkList(){
       first=null;
       last=null;
   }
    public boolean isEmpty(){
        return first == null;
    }
   public void insertFirst(long NIM, double score){
        ObjekData newLink= new ObjekData(NIM,score);
        if (isEmpty()) {
            last=newLink;
        }else{
            first.previous=newLink;
        }
        newLink.next=first;
        first = newLink;
    }
   public void displayForward(){
        System.out.println("List "+"first --> last : ");
        ObjekData current = first;
        while(current != null){
            current.display();
            current =current.next;
        }
        System.out.println("");
    }
  public void sortList() {  
        ObjekData current = null, index = null;  
        int temp;  
       
        if(first == null) {  
            return;  
        }  
        else {  
            
            for(current = first; current.next != null; current = current.next) {  
               
                for(index = current.next; index != null; index = index.next) {  
                     
                    if(current.score > index.score) {  
                        temp = (int) current.score;  
                        current.score = index.score;  
                        index.score = temp;  
                    }  
                }  
            }  
        }  
    }
  public double getJmlScore(){
      ObjekData temp=first;
      double count=temp.score;
      while(temp != null){
          count++;
          temp=temp.next;
      }
      return count;
  }
  public int getCount() 
    { 
        ObjekData temp = first; 
        int count = 0; 
        while (temp != null) 
        { 
            count++; 
            temp = temp.next; 
        } 
        return count; 
    } 
  public double ratarata(){
      
      double ratarata= getJmlScore()/getCount();
      return ratarata;
  }
  
  public void median() 
    { 
        ObjekData temp1 = first; 
        ObjekData temp2 = first; 
        if (first != null) 
        { 
            while (temp2 != null && temp2.next != null) 
            { 
                temp2= temp2.next.next; 
                temp1 = temp1.next; 
            } 
            System.out.println("The middle element is [" + 
                                temp1.score + "] \n"); 
        } 
    }
  public void kuartil1(){
      ObjekData temp1 = first; 
        ObjekData temp2 = first; 
        if (first != null) 
        { 
            while (temp1 != null && temp1.next != null) 
            { 
                temp2= temp2.next; 
                temp1 = temp1.next.next;
                temp2.next=temp2;
            } 
            System.out.println("kuartil 1[" + 
                                temp2.score + "] \n"); 
        } 
  }
  public void kuartil2(){
      ObjekData temp1 = first; 
        ObjekData temp2 = first; 
        if (first != null) 
        { 
            while (temp1 != null && temp1.next != null) 
            { 
               temp2= temp2.next; 
                temp1 = temp1.next.next;
                temp2.next.next=temp2.next;
                
               
            } 
            System.out.println("kuartil 2[" + 
                                temp2.next.score + "] \n"); 
        } 
  }
    
}
