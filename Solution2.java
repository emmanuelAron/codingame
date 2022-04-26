import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        
        //TODO : detect and count the number of neighbor of a cell.

        Board b = new Board(width,height,in);
        Cellule cellule_i_j ;
        
        for (int i = 0; i < height; i++) { 
            for (int j = 0; j < width; j++) {
                 cellule_i_j = b.cellulesInitiales[j][i];
                  System.err.println("get Number Of Neighbors: "+cellule_i_j);
            }
        }
       // System.out.println("width: "+width);
    }
}

class Board{
    
    int height;
    int width;
    Cellule[][] cellulesInitiales;
    Cellule[][] cellulesFinales;
    String line;
    /**
     * width = x
     * height = y
     */
    public Board(int width , int height, Scanner in){
        this.height = height;
        this.width = width;
        cellulesInitiales = new Cellule[width][height];
        
        System.err.println("height: "+height+" width: "+width);
        for(int i=0; i<height;i++){
            line = in.next();
            for(int j=0;j<width;j++){
                char stateCell = line.charAt(j);
                //Cell of width j and height i  (creation of the initial board)
                cellulesInitiales[j][i] = new Cellule(j,i,stateCell); 
                
            }
        }
        System.err.println(cellulesInitiales[1][1]);
    }
}

 class Cellule {
        private int x;
        private int y;
        private char state;//alive: state=='1' ; dead: state=='0'
        private int numberOfNeighbors;
        private int[] neighbors;
    
        public Cellule(int x,int y,char state){
            this.x=x;
            this.y=y;
            this.state = state;
        }
         public Cellule(int x,int y,char state, int numberOfNeighbors){
            this.x=x;
            this.y=y;
            this.state = state;
            this.numberOfNeighbors = numberOfNeighbors;
        }
        public Cellule(int x,int y){
            this.x=x;
            this.y=y;
        }
        public Cellule(){
            
        }
        public void setNumberOfNeighbors(int numberOfNeighbors){
            this.numberOfNeighbors = numberOfNeighbors;
        }
        public int getNumberOfNeighbors(){
            return numberOfNeighbors;
        }
        public void setX(int x){
            this.x = x;
        }
        public void setY(int y){
            this.y = y;
        }
         public void setState(char state){
            this.state = state;
        }
        public char getState(){
            return state;
        }
        public int getX(){
            return x;
        }
         public int getY(){
            return y;
        }
       
        /*
        @param state : initial state of the cell
        @return next state of the cell
        */
        public char getNextState(){
           // char nextState = ' ';
            //alive cell
            if(state == '1'){
                //case 1 : death by underpopulation
                if(numberOfNeighbors < 2){
                    return '0';
                }
                if(numberOfNeighbors == 2 || numberOfNeighbors == 3){
                    return '1';
                }
                if(numberOfNeighbors > 3){
                    return '0';
                }
            }
            
            //dead cell
            if(state == '0'){
                if(numberOfNeighbors == 3){
                    return '1';
                }else{
                    return '0';
                }
            }
            
            return 'p'; 
         }
        public String toString(){
            return "[x: "+x+"| y: "+y+"| state: "+state+"| numberOfNeighbors: "+numberOfNeighbors+"]";
        }
    }
