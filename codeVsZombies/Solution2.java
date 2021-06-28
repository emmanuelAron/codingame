import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

/**
 * Save humans, destroy zombies!
 **/
class Player {

    static int x = 0;
    static int y = 0;

    static int humanId = 0;
    static int humanX = 0;
    static int humanY= 0;

    static int zombieId= 0;
    static int zombieX= 0;
    static int zombieY= 0;
    static int zombieXNext = 0;
    static int zombieYNext= 0;

    static int ashStep = 1000;

    /**
        Incremente l'abscisse de Ash d'un AshStep (va a droite)
    **/
    static void droite(){
        x =  x + ashStep;
    }
     /**
        Decremente l'abscisse de Ash d'un AshStep (va a gauche)
    **/
    static void gauche(){
        x =  x - ashStep;
    }

    /**
        Incremente l'ordonnee de Ash d'un AshStep (va en bas)
    **/
    static void bas(){
        y =  y + ashStep;
    }
    /**
        Incremente l'ordonnee de Ash d'un AshStep (va en haut)
    **/
    static void haut(){
        y =  y - ashStep;
    }
    /**
        Distance entre deux points a : (x1,y1) et b : (x2,y2)
    **/
    static double dist(int x1 ,  int y1, int x2, int y2){
         return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int [] xs = new int[40];
        int [] ys = new int[40];


        int t = 0;//nombre de tours
        // game loop
        while (true) {
            x = in.nextInt();
            y = in.nextInt();

            xs[t] = x;//tableau de x
            ys[t] = y;//tableau de y

           // Point2D p = new Point2D.Double(x, y); 
            

            int humanCount = in.nextInt();
            for (int i = 0; i < humanCount; i++) {
                 humanId = in.nextInt();
                 humanX = in.nextInt();
                 humanY = in.nextInt();
            }
            int zombieCount = in.nextInt();
            for (int i = 0; i < zombieCount; i++) {
                 zombieId = in.nextInt();
                 zombieX = in.nextInt();
                 zombieY = in.nextInt();
                 zombieXNext = in.nextInt();
                 zombieYNext = in.nextInt();
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            //distance entre Ash et un zombie
            double distAshZombie =  dist(x , zombieX , y, zombieY);

            //distance entre Ash et un humain
            double distAshHumain =  dist(x , humanX , y, humanY);
           
            double distZombieHumain =  dist(zombieX , humanX , zombieY, humanY);

            if(y < zombieY){
                bas();
                System.err.println("b");
            }else{
                haut();
                System.err.println("h");
                if( x < zombieX){
                    bas();
                    System.err.println("x");
                }
            }
            if( x < zombieX){
                droite();
                System.err.println("d");
            }else{
                gauche();
                System.err.println("g");
                if(y < zombieY){
                    haut();//tester
                    System.err.println("y");
                }
            }

            String result = ""+x+" "+y;
            t++;
            System.out.println(result); // Your destination coordinates
        }
    }
}
