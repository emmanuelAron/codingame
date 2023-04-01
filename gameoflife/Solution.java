import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static List<Cellule> getNeighbors(int x,int y , Board b){
        int width = b.width;
        int height = b.height;
       
        Cellule cell = new Cellule(x,y);
        Cellule east = null;
        Cellule west = null;
        Cellule north = null;
        Cellule south = null;
        Cellule northWest = null;
        Cellule northEast = null;
        Cellule southWest = null;
        Cellule southEast = null;

        char cellState = cell.getState();  
        System.err.println("cell state: "+cellState); 
        List<Cellule> neighbors = new ArrayList<Cellule>();

        if(x+1 <= width)
            east = new Cellule(x+1,y);
        if(x-1 >=0)
            west = new Cellule(x-1,y);
        if(y-1>=0)
            north = new Cellule(x,y-1);
        if(y+1 <= height)
            south = new Cellule(x,y+1);
        if(x-1 >=0 && y-1>=0)
            northWest = new Cellule(x-1,y-1);
        if(x+1 <= width && y-1>=0)    
            northEast = new Cellule(x+1,y-1);
        if(x-1 >=0 && y+1 <= height)
            southWest = new Cellule(x-1,y+1);
        if(x+1 <= width && y+1 <= height)
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

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        
        Board b = new Board(width,height,in);
       // System.err.println(b);
        
       // System.err.println(" "+getNeighbors(0, 0, b)) ;
        Cellule cellule_i_j ;   
    }
}

class Board{
    int height;
    int width;
    Cellule[][] cellulesInitiales;
    Cellule[][] cellulesFinales;
    String line;
    char stateCell;

    public void printInitialArrayState(/**Scanner in **/){
        System.err.println(" * printInitialArrayState * ");
         //Get (and eventually print) the initial array state.
        for(int i=0; i<height;i++){
           // line = in.next();
            for(int j=0;j<width;j++){
              //  stateCell = line.charAt(i);
                //System.err.print(stateCell);
                //Cell of width i and height j  (creation of the initial board)
                cellulesInitiales[i][j] = new Cellule(i,j,stateCell);   
                System.err.print( cellulesInitiales[i][j] );    
            }
            System.out.println();
        }
    }

    public void initToZeroFinalState(){
         for(int i=0; i<height;i++){
            //line = in.next();
            for(int j=0;j<width;j++){
                //System.err.print(" i: "+i+" j: "+j);
                cellulesFinales[i][j] = new Cellule(0,0,'0',0,null);
            }
            System.err.println();
         }
    }

    public void printFinalArrayState(Scanner in){
        System.err.println(" * printFinalArrayState * ");
         //Get (and eventually print) the final array state.
        for(int i=0; i<height;i++){
            line = in.next();
            for(int j=0;j<width;j++){
                stateCell = line.charAt(i);  
                cellulesFinales[i][j] = new Cellule(i,j,stateCell);  
                System.err.print( cellulesFinales[i][j] );
            }
            System.out.println();
        }
    }


    /**
     * width = x
     * height = y
     */
    public Board(int width , int height, Scanner in){
        this.height = height;
        this.width = width;
        cellulesInitiales = new Cellule[width][height];
        cellulesFinales = new Cellule[width][height];
        
        //Get (and eventually print) the initial array state.
        printInitialArrayState();
       
       // initToZeroFinalState();
        printFinalArrayState(in);
       
    }
    public String toString(){
        StringBuilder sb = new StringBuilder(100);
        for (int i = 0; i < cellulesFinales.length; i++) {
            for (int j = 0; j < cellulesFinales[i].length; j++) {
                sb.append(cellulesFinales[i][j] + " ");
            }
            sb.append(System.getProperty("line.separator"));
        }
        return "\n"+sb.toString();
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
        public Cellule(int x,int y,char state, int numberOfNeighbors,int[] neighbors){
            this.x=x;
            this.y=y;
            this.state = state;
            this.numberOfNeighbors = numberOfNeighbors;
            this.neighbors = neighbors;
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
            System.err.println("Begin of getNextState");
           // char nextState = ' ';
            //alive cell
            if(state == '1'){
                System.err.println("State 1");
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
                System.err.println("State 0");
                if(numberOfNeighbors == 3){
                    return '1';
                }else{
                    return '0';
                }
            }  
            return 'p'; 
         }
        public String toString(){
            return "[x: "+x+"| y: "+y +"| state: "+state+"| numberOfNeighbors: "+numberOfNeighbors+"] ";
           // return ""+state;
        }
    }
