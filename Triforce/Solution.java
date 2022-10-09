import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
       
        printTriangleSizeN(N);
        
        System.out.println(addTwoStarsNtimesBis(N));
        
    }
    
    public static String getLineOfNSpaces(int N){
        String line = "";
        for(int i=0;i<N;i++){
           
            line+=" ";
        }
        return line;
    }
    
    public static String addTwoStarsNtimes(int N){
        String ch = "*";//at start we have 1 star..
        for(int i=0;i<N;i++){
            ch+="**";
        }
        return ch;
    }
     public static String addTwoStarsNtimesBis(int N){
         String c = "";
        String ch = "*";//at start we have 1 star..
        String ch2 = "*";
       // int j=0;
        for(int i=0;i<N;i++){
            ch+="**";
            ch2+="**";
           // c = ch+"   "+ch2;
           c = ch+getLineOfNSpaces(i)+ch2;
        }
        return c;
    }
    public static void printTriangleSizeN(int N){
         for(int i=N;i>0;i--){
            String ch2 = getLineOfNSpaces(i);
           // ch2 = ch2 + addTwoStarsNtimes(N-i);
            ch2 = ch2 + addTwoStarsNtimesBis(N-i);
            System.out.println(ch2);
        }
    }
     
    
}
