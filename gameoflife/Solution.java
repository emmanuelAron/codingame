import java.util.*;
import java.io.*;
import java.math.*;

class Cellule {
    int x;
    int y;
    char state;
    int numberOfNeighbors;
    Cellule(int x,int y,char state){
        this.x=x;
        this.y=y;
        this.state = state;
    }
    Cellule(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public char getNextState(char state){
        char nextState = ' ';
        //alive cell
        if(state == '1'){
            if(numberOfNeighbors < 2){
                nextState = '0';
            }
            if(numberOfNeighbors == 2 || numberOfNeighbors == 3){
                nextState = '1';
            }
            if(numberOfNeighbors > 3){
                nextState = '0';
            }
        }
        if(state == '0'){
            if(numberOfNeighbors == '3'){
                nextState = '1';
            }
        }
        return nextState; 
     }
    public String toString(){
        return "x: "+x+"y: "+y;
    }
}
class Solution {

    static Scanner in = new Scanner(System.in);
    static int width = in.nextInt();
    static int height = in.nextInt();
    public static List<Cellule> getNeighbors(int x,int y){
       
        Cellule cell = new Cellule(x,y);
        Cellule east = null;
        Cellule west = null;
        Cellule north = null;
        Cellule south = null;
        Cellule northWest = null;
        Cellule northEast = null;
        Cellule southWest = null;
        Cellule southEast = null;
        
        List<Cellule> neighbors = new ArrayList<Cellule>();
        if(x+1 < width)
            east = new Cellule(x+1,y);
        if(x-1 >=0)
            west = new Cellule(x-1,y);
        if(y-1>=0)
            north = new Cellule(x,y-1);
        if(y+1 < height)
            south = new Cellule(x,y+1);
        
        northWest = new Cellule(x-1,y-1);
        northEast = new Cellule(x+1,y-1);
        southWest = new Cellule(x-1,y+1);
        southEast = new Cellule(x+1,y+1);
        
        neighbors.add(east);
        neighbors.add(west);
        neighbors.add(north);
        neighbors.add(south);
        neighbors.add(northWest);
        neighbors.add(northEast);
        neighbors.add(southWest);
        neighbors.add(southEast);
        
        return neighbors;
    }
    public static List<Cellule> getEtatInitial(String line){
        char c0 = line.charAt(0);
        return null;
    }
    public static void main(String args[]) {
        List<Cellule> cellules = new ArrayList<Cellule>();
        List<Cellule> neighbors = getNeighbors(1,1);
        //System.out.println(neighbors);
        //int[] initialsStates = new int[width];
        List<Integer> initialsStates = new ArrayList<Integer>();
        
        String line = "";
        for (int i = 0; i < height; i++) {
            line = in.next();
            //affichage de l'etat initial ...
            for(int j=0;j< width ; j++){
                initialsStates.add(Character.getNumericValue(line.charAt(j)));
            }
        }
        System.out.println(initialsStates);
       for(Integer state_ini : initialsStates){
           
       }
       // A FAIRE : 
       // 1) FINIR LE NOMBRE DE VOISINS
       // 2) tester getNextState
    }
}
