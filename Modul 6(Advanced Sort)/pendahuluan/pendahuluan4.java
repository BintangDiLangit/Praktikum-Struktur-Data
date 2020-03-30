/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendahuluan_prak_6;

class ArrayPar {

    private long[] arr;
    private int nEl;

    public ArrayPar(int max) {
        arr = new long[max];
        nEl = 0;
    }

    public void insert(long value) {
        arr[nEl] = value;
        nEl++;
    }

    public void display() {
        for (int i = 0; i < nEl; i++) {
            System.out.print(arr[i] + " ");
        }
            System.out.println("");
    }

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
            }
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    public void swap(int dex1, int dex2) {
        long temp = arr[dex1];
        arr[dex1] = arr[dex2];
        arr[dex2] = temp;
    }

    public int size() {
        return nEl;
    }

}

public class pendahuluan4 {

    public static void main(String[] args) {
        int maxSize = 16;
        ArrayPar a = new ArrayPar(maxSize);
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

        long pivot = 30;
        System.out.print("Pivot is " + pivot);
        int size = a.size();

        int partDex = a.partitionIt(0, size - 1, pivot);
        System.out.println(", Partition is at index " + partDex);
        a.display();
    }
}
