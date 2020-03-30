/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendahuluan_prak_5;
class recursion{
    public int triangleIter(int n){
        int result = 0;
        for (int i = n; i > 0; i--) {
            result+=i;  // kalau dirubah n akan menjadi pangkat
        }
        return result;
    }
    
    public int triangleRecur(int n){
        if (n==1) {
            return 1;
        }else{
            return n+triangleRecur(n-1);
        }
    }
    public int fakIter(int p){
        int r = 1;
        for (int i = 1; i <= p; i++) {
            r*=i;
        }
        return r;
    }
    public int fakRec(int p){
        if (p==1) {
            return 1;
        }else{
            return p*fakRec(p-1);
        }
    }
    public int printNilai(int p){
        System.out.print(p+" ");
        if (p==0) {
            return p;
            
        }
        p--;
        return printNilai(p);
    }
}
public class recursionApp {
    public static void main(String[] args) {
        recursion r = new recursion();
        System.out.println("a");
        System.out.println(r.triangleIter(5));  // pangkat
        System.out.println("b");
        System.out.println(r.triangleRecur(5)); // recursion of triangle
        System.out.println("c");
        System.out.println(r.fakIter(5));
        System.out.println("d");
        System.out.println(r.fakRec(5));
        System.out.println(r.printNilai(5));
    }
}
