import java.util.*;
import java.io.*;
import java.math.*;

class Player {
    public static double distance(int X0,int Y0,int X1,int Y1){
        return Math.sqrt((Y1 - Y0)*(Y1 - Y0) + (X1 - X0)*(X1 - X0));
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        int cpt = 1;

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            int step = 1;
            if(W==1){//Vertical Tower
                    do{
                        if(cpt!=1){
                            step=H/(2*cpt); 
                        }else{
                         if(Math.min(W/2,H/2) < W-X0 && Math.min(W/2,H/2) < H-Y0)
                            step = Math.min(W/2,H/2); 
                 }
                }while(cpt > H);
            }
            if(H==1){//Line Tower
                    do{
                        if(cpt!=1){
                            step=W/(2*cpt); 
                        }else{
                             if(Math.min(W/2,H/2) < W-X0 && Math.min(W/2,H/2) < H-Y0)
                                step = Math.min(W/2,H/2); 
                        }
                     //   }
                }while(cpt > W);
            }/**else{
                if(cpt==1){
                    //System.err.println("valeur: "+Math.min(W/2,H/2));
                    if(Math.min(W/2,H/2) < W-X0 && Math.min(W/2,H/2) < H-Y0)
                        step = Math.min(W/2,H/2); 
                }
            }**/
            

            
           
            switch(bombDir){
                case "U": 

                 if(Y0>0){
                        Y0-= step;
                    }else{
                        Y0+= step;
                    }
                break;
                case "UR":{
                    Y0-= step;
                    X0+= step;
                }break;
                case "R":
                if(X0<W)
                    X0+= step;
                else{
                    X0-= step;
                    }break;
                case "DR":{Y0+= step;X0+= step;}break;
                case "D":{Y0+=step;System.err.println("STEP: "+step+" cpt: "+cpt+" ; width: "+W+" ; height: "+H);}break;
                case "DL":{
                    Y0+= step;
                    X0-= step;
                }break;
                case "L":{
                    if(X0>0)
                        X0-= step;
                    else{
                        X0+= step;
                    }
                        }
                    break;
                case "UL":{
                    X0-= step;
                    Y0-= step;
                }break;
                
            }
            System.err.println("bombDir..."+bombDir);

            // the location of the next window Batman should jump to.
           // String location = "0 0";
              String location = X0+" "+Y0;
            System.out.println(location);
            cpt++;
            System.err.println("cpt: "+cpt +" ; N:" + N);
        }
    }
}
