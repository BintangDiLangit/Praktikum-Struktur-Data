/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendahuluan_prak_6;

class uwu {

    private int[] arr;
    private int nEl;

    public uwu(int max) {
        arr = new int[max];
        nEl = 0;
    }

    public void insert(int value) {
        arr[nEl] = value;
        nEl++;
    }

    public void display() {
        for (int i = 0; i < nEl; i++) {
            System.out.print(arr[i] + " ");
        }
            System.out.println("");
    }
    public void QuickSort(){
        recQuickSort(0,nEl-1);
    }
    public void recQuickSort(int bataskiri,int bataskanan){
        if (bataskanan-bataskiri<=0) {
            return;
        }else{
            int pivot = arr[bataskanan];
            int partisi = partitionIt(bataskiri, bataskanan, pivot);
            recQuickSort(bataskiri, partisi-1);
            recQuickSort(partisi+1,bataskanan);
        }
    }

//    public int partitionIt(int left, int right, int pivot) {
//        int leftPtr = left - 1;
//        int rightPtr = right + 1;
//        while (true) {
//            while (leftPtr < right && arr[++leftPtr] < pivot);
//
//            while (rightPtr > left && arr[--rightPtr] > pivot);
//
//            if (leftPtr >= rightPtr) {
//                break;
//            } else {
//                swap(leftPtr, rightPtr);
//            }
//        }
//        return leftPtr;
//    }
    public int partitionIt(int left, int right, long pivot) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            while (leftPtr < right && arr[++leftPtr] < pivot);

            while (rightPtr > left && arr[--rightPtr] > pivot);

            if (leftPtr >= rightPtr) {//can left
                break;
            } else {
                swap(leftPtr, rightPtr);
                display();
                System.out.println("-----------------------");
            }
        }
        swap(leftPtr, right);
        display();
        System.out.println("=-=--==--==--=-=-=--=-=-=-=-");
        return leftPtr;
    }

    public void swap(int dex1, int dex2) {
        int temp = arr[dex1];
        arr[dex1] = arr[dex2];
        arr[dex2] = temp;
    }

    public int size() {
        return nEl;
    }

}
public class pendahuluan5 {
    public static void main(String[] args) {
        int maxSize = 16;
        uwu a = new uwu(maxSize);
        a.insert(60);
        a.insert(5);
        a.insert(15);
        a.insert(45);
        a.insert(35);
        a.insert(20);
        a.insert(25);
        a.insert(10);
        a.insert(50);
        a.insert(30);
        a.display();
        System.out.println("===================");
        a.QuickSort();
        a.display();
    }
}
