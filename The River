import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    static int calcSomme(long r){
        int somme = 0;
        while(r != 0){
            somme += r%10;
            r /= 10;
        }
        return somme;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long r1 = in.nextLong();
        long r2 = in.nextLong();
        int s1 = 0;
        int s2 = 0;
        System.err.println(r1);
        System.err.println(r2);
        s1 = calcSomme(r1);
        s2 = calcSomme(r2);
        System.err.println("somme de r1: "+s1);
        System.err.println("somme de r2: "+s2);
     
    }
}
