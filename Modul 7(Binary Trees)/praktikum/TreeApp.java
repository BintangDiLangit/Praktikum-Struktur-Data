/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author BintangDiLangit
 */
public class TreeApp {
    public static void main(String[] args) throws IOException {
        int value;
        String data;
        tree theTree = new tree();
        theTree.insert(50, "Ahmad");
        theTree.insert(25, "Rosa");
        theTree.insert(75, "Raisa");
        theTree.insert(12, "Naya");
        theTree.insert(37, "Gagas");
        theTree.insert(43, "Ainun");
        theTree.insert(30, "Beri");
        theTree.insert(33, "Vivid");
        theTree.insert(87, "Orin");
        theTree.insert(93, "Wiwid");
        theTree.insert(97, "Sasa");
        
        while (true) {            
            System.out.println("Enter first letter of show, insert, find, delete, traverse, besar, keci; : ");
            int choice = getChar();
            switch(choice){
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.println("Enter value and data to insert: ");
                    value = getInt();
                    data = getString();
                    theTree.insert(value, data);
                    break;
                case 'f':
                    System.out.println("Enter value to find: ");
                    value = getInt();
                    Node found = theTree.find(value);
                    if (found!=null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.print("\n");
                    }else{
                        System.out.println("Could not find value");
                    }
                    break;
                case 'd':
                    System.out.print("Enter value to delete: ");
                    value = getInt();
                    boolean didDelete = theTree.delete(value);
                    if (didDelete) {
                        System.out.println("Deleted "+value);
                    }else{
                        System.out.println("Could not delete value");
                    }
                    break;
                case 't':
                    System.out.print("Enter type 1, 2 or 3: ");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                case 'b':
                    System.out.println(theTree.max(theTree.root));
                    break;
                case 'k':
                    System.out.println(theTree.min(theTree.root));
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }
    public static int getInt() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }
    
   

}
