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

    //retourner une liste d'integer puis boucler sur la liste pour tester la valeur commune?(ok)
    //il manque le premier terme! (dans la somme)
    static List<Integer> computeSequence(long r1){
        List<Integer> l = new ArrayList<>();
        int s1 = 0;
        s1 = calcSomme(r1);
        System.err.println("debut s1: "+s1);
        if(s1 < 10){
            s1 = 2*s1;
          //  System.err.println("la "+s1);
            l.add(s1);
        }else{
            for(int i=0;i<4;i++){
                if(s1 < 10){
                    s1 = 2*s1;
                  //  System.err.println("la "+s1);
                    l.add(s1);
                }else{
                     s1 += calcSomme(s1);
                   // System.err.println("ici "+s1);
                    l.add(s1);
                }
               
            }
        }
        return l;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long r1 = in.nextLong();
        long r2 = in.nextLong();
        
        int tot1 = 0;
        System.err.println("entree 1: "+r1);
      //  System.err.println("entree 2: "+r2);
        List<Integer> l1 = computeSequence(r1);
        List<Integer> l2 = computeSequence(r2);

        for(int i=0;i<l1.size();i++){
            for(int j=0;j<l1.size();j++){
                if(l1.get(i).equals(l2.get(j))){
                    System.out.println(l2.get(j));
                }
            }
        }
       
    }
}
