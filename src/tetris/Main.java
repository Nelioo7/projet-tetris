package tetris;

import java.io.IOException;

public class Main {
    
    static long timeWait = 10;

    public static boolean gameOver(Carte tab) {
        for(int i = 0; i < tab.getMap()[0].length; i++) {
            if(tab.getMap()[0][i].isOccupe()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Carte tab = new Carte();
        try{
            while (Main.gameOver(tab)) {;
                Bloc block = new L(tab);
                block.getDown(tab);
                for (int i=0 ; i<block.getCases().length ; i++){
                    block.getMap()[block.getCases()[i].getPosY()][block.getCases()[i].getPosX()].setOccupe(true);
                }
            }
        } catch(InterruptedException ie){}
        catch(IOException ioe){}

        try{
            Affichage.afficherGameOver(tab);
        } catch (IOException e) {}

        Affichage.afficherPhrase("Appuyez sur"+ Affichage.ROUGE + " ENTER ⏎ " + Affichage.RESET+ "pour lancer une nouvelle partie", 2);



    }
}
