package Praktikum_1;

import java.util.Arrays;

class HighArray {

    private int arr[];
    private int nElement;

    public HighArray(int max) {
        arr = new int[max];
        nElement = 0;
    }

    public int insertOrdered(int value) {
//        if (nElement>=arr.length) 
//            return nElement;
//        System.out.println(Arrays.toString(arr));
//        System.out.println(nElement-1);
        int i;
        for (i = nElement-1; (i >= 0 && arr[i]> value); i--) 
            arr[i+1]=arr[i];
        
        arr[i+1] = value;
                
        return nElement++;    
       
        
    }

    public int binarySearch(int key) {
        int bb=0,ba=nElement-1;
       while(bb<=ba){
           int mid=bb+(ba-bb)/2;
           if (arr[mid]==key) 
               return mid;
           
           if (arr[mid]>key) 
               ba=mid-1;
           
           if (arr[mid]<key) {
               bb=mid+1;
           }
     
       }
       return -1;
    }

    public boolean delete(int value) {
        int i;
        for (i = 0; i < nElement; i++) {
            if (value == arr[i]) {
                break;
            }
        }
        if (i == nElement) {
            return false;
        } else {
            for (int j = i; j < nElement; j++) {
                arr[j] = arr[j + 1];
            }
            nElement--;
            return true;
        }
    }

    public void display() {
        for (int i = 0; i < nElement; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public void size() {
        System.out.println("Jumlah Element Array = " + this.arr.length);
        System.out.println("Jumlah Element yang terisi = " + nElement);
    }

}

public class HighArrayApp {

    public static void main(String[] args) {
        int maxSize = 100;
        HighArray arr;

        arr = new HighArray(maxSize);

        arr.insertOrdered(70);
        arr.insertOrdered(80);
        arr.insertOrdered(75);
        arr.insertOrdered(55);
        arr.insertOrdered(85);
        arr.insertOrdered(25);
        arr.insertOrdered(30);
        arr.insertOrdered(11);
        arr.insertOrdered(90);
        arr.insertOrdered(40);

        arr.display();
        arr.size();

        int find = arr.binarySearch(80);
        if (find==-1) {
            System.out.println("not found");
        }else{
            System.out.println("Found at index "+find);
        }
       

        arr.delete(11);
        arr.delete(80);
        arr.delete(55);

        arr.display();

        arr.size();
    }
}
