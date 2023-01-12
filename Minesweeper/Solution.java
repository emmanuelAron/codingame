import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
    int abs_x =0 ; int ord_x = 0;

        //grille du jeu
        char[][] grid = new char[h][w];
        String line = "";
        for (int i = 0; i < h; i++) {
         //   Coordinates coord ;
            int lineNumber = i; //start at 0
            line = in.nextLine();

            int cpt = 0;
        char mines = Character.forDigit(cpt,20);//conversion du nombre de bombes en char.
      
            for (int j = 0; j < line.length(); j++) {
                //recuperation du motif en general
                char motif = line.charAt(j);
                grid[i][j] = motif;
                if(motif == 'x'){
                    ++cpt;
                    ++mines;
                    abs_x = i;
                    ord_x = j;
                    
                    //line at top
                    grid[i-1][j] = mines; // System.err.println(" grid[i-1][j]: "+grid[i-1][j] +" i: "+i);
                    grid[i-1][j-1] = mines;System.err.println(" grid[i-1][j-1]: "+grid[i-1][j-1] +" i: "+i+" j: "+j);
                    grid[i-1][j+1] = mines;
                   
                    //line at x level
                    grid[i][j-1] = mines;       
                    
                }
            }
          // System.err.println();
            
            if(abs_x > 0){
                ++mines;
                //line at x level    
                grid[abs_x][ord_x+1] = mines;    
                //line at bottom
                grid[abs_x+1][ord_x] = mines;
                grid[abs_x+1][ord_x-1] = mines;
                grid[abs_x+1][ord_x+1] = mines;

                grid[abs_x][ord_x] = '.';//motif
            }
           
                            
        }
        //print grid
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < line.length(); j++) {
                System.out.print( grid[i][j]);
            }
            System.out.println();
        }
         
    }
}