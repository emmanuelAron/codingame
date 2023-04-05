import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        Cellule[][] cells = new Cellule[200][200];
        char stateCell;
        char aliveCell;
        char deadCell;
        for (int i = 0; i < height; i++) {
            String line = in.next();
            for(int j=0;j< width;j++){
                stateCell = line.charAt(j);   
                cells[i][j] = new Cellule(i,j,stateCell);
               // System.err.print(cells[i][j].getState());
                int neighborsCell = countAliveNeighborsCell(cells[i][j],width,height);
                System.err.println("neighborsCell: "+neighborsCell);
            }
        }

        System.out.println(cells[0][0]);
    }

    public static int countAliveNeighborsCell(Cellule c,int width,int height){
        int cpt = 0;
        int east;
        int west;
        int north;
        int south;
        int northEast;
        int northWest;
        int southEast;
        int southWest;
        if(c.getX()+1 < width ){
            //EAST
            east = c.getX()+1;
            Cellule e = new Cellule(east, c.getY(),c.getState());//c.getState?
            //TODO get du state east
            char stateEast;
            e.setState(stateEast);
            if(e.getState() == '1')
                cpt++;
           // System.err.println("e.getState(): "+e.getState()+" ; X: "+e.getX()+" ; Y: "+e.getY());
            if(c.getY()-1 > 0){
                //NORTH-EAST
                northEast = c.getY()-1;
                Cellule ne = new Cellule(east, northEast,c.getState());//c.getState?
                if(ne.getState() == '1')
                    cpt++;
               // System.err.println("ne.getState(): "+ne.getState()+" ; X: "+ne.getX()+" ; Y: "+ne.getY());
            }
            if(c.getY()+1 > height){
                //SOUTH-EAST
                southEast = c.getY()+1;
                Cellule se = new Cellule(east, southEast,c.getState());//c.getState?
                if(se.getState() == '1')
                    cpt++;
            }
                
        }
        if(c.getX()-1 > 0 ){
            //WEST
            west = c.getX()-1;
            if(c.getY()-1 > 0){
                //NORTH-WEST
                northWest = c.getY()-1;
                Cellule nw = new Cellule(west,northWest,c.getState());//c.getState?
                if(nw.getState() == '1')
                    cpt++;
            }
            if(c.getY()+1 > height){
                //SOUTH-WEST
                southWest = c.getY()+1;
                Cellule sw = new Cellule(west,southWest,c.getState());//c.getState?
                if(sw.getState() == '1')
                    cpt++;
            }
                
        }
        if(c.getY()-1 > 0){
            //NORTH
            north = c.getY()-1;
            Cellule n = new Cellule(c.getX(),c.getState());//c.getState?
            if(n.getState() == '1')
                cpt++;
        }
            
        if(c.getY()+1 > height){
            //SOUTH
            south = c.getY()+1;
            Cellule s = new Cellule(c.getX(),south,c.getState());//c.getState?
            if(s.getState() == '1')
                cpt++;
        }      

        return cpt;
    }
}

class Cellule {
        private int x;
        private int y;
        private char state;//alive: state=='1' ; dead: state=='0'
        private int numberOfNeighbors;
       
    
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
