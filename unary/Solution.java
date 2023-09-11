
import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();
        char[] caracteres = MESSAGE.toCharArray();
        String chaine_sept = "";
        String phraseBinaire = "";
        String phraseUnaire = "";
        String groupeUnaire = "";
       
        for(char c : caracteres){
            int entier = (int)c;
            String chaine = Integer.toBinaryString(entier);
           
            int taille = chaine.length();
            //on verifie que l'on a bien des caractères 
            // ASCII en entrée (donc de longueur 7)
            if(taille == 6){
                chaine_sept = "0"+chaine;
                
            }else if(taille == 7){
                chaine_sept = chaine;
            }
        //on stocke tout nos caractères ascii sur une seule
        //chaine de maniere à former une 'phrase' ASCII
        phraseBinaire += chaine_sept;
        
        //on sépare les groupes de 0 et de 1 (par un espace)
        phraseBinaire = phraseBinaire.replaceAll("01","0 1");
        phraseBinaire = phraseBinaire.replaceAll("10","1 0");
        }
        String[] phraseBinaireTab = phraseBinaire.split(" ");
       //on convertit en unaire en suivant le principe
        //d'encodage
         String premierBloc = "";
         String deuxiemeBloc = "";
         for(int i=0;i< phraseBinaireTab.length;i++){
             String groupeBinaire = phraseBinaireTab[i];
             int tailleGroupeBinaire = groupeBinaire.length();
             for(int j=0;j< tailleGroupeBinaire;j++){
                 char bit = groupeBinaire.charAt(j);
                 if(bit == '1'){
                     premierBloc = "0";
                     deuxiemeBloc = getSecondBloc(tailleGroupeBinaire,bit);
                 }else if(bit == '0'){
                     premierBloc = "00";
                     deuxiemeBloc = getSecondBloc(tailleGroupeBinaire,bit);
                 }
                 groupeUnaire = premierBloc +" "+ deuxiemeBloc;
             }
            phraseUnaire += groupeUnaire+" ";
         }
         //suppression du dernier caractere
         phraseUnaire = phraseUnaire.substring(0,phraseUnaire.length()-1);
           System.out.println(phraseUnaire);
    }
    public static String getSecondBloc(int tailleBloc, char bit){
        String secondBloc = "";
        secondBloc += '0';
        for(int i=0; i< tailleBloc-1; i++){
            secondBloc += '0';
        }
        return secondBloc;
    }
}

