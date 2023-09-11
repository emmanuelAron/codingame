import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
   public static int[] conversion(String chaine){
		String[] tabString = chaine.split(" ");
		int[] result = new int[tabString.length];
		
		if(chaine.isEmpty())
		{
		    result = new int[]{0};
		}
		else
		for(int i = 0;i<tabString.length;i++)
		{
			result[i] = Integer.parseInt(tabString[i]);
		}
		return result;
	}

    public static int minimum(int[] mesEntiers){
                int min;
		int minPositif = 10000;
                int minNegatif = 10000;
		for(int i = 0;i<mesEntiers.length;i++){
                    //les entiers negatifs du tableau
		    if(mesEntiers[i] < 0)
		    {
			    if(Math.abs(mesEntiers[i]) < Math.abs(minNegatif) )
			    {
				    minNegatif = mesEntiers[i];
			    }
		    }
                    //les entiers positifs du tableau
		    if(mesEntiers[i] > 0)
		    {
			    if(mesEntiers[i]<minPositif)
			    {
				    minPositif = mesEntiers[i];
			    }
		    }  
		}
               if(minNegatif == -minPositif)
               {
                   minNegatif = -minNegatif;
                   return minNegatif;
               }
               else if(Math.abs(minNegatif) < minPositif)
               {
                   return minNegatif;
               }
               else return minPositif;
	}


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
       
        String TEMPS = in.nextLine(); // the N temperatures expressed as integers ranging from -273 to 5526
        
        int entier = 10000;
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
      
      System.err.println(TEMPS);
      
       int[] mesInts = conversion(TEMPS);
       entier = minimum(mesInts); 
       
      
       
        if(TEMPS.length() == 0)
        {
            System.out.println(0);
        }
        else
        {
            System.out.println(entier);
        }
        
    }
}
