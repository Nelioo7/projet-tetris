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
    
    /*public static void getDown(Carre carre, Carte tab) throws InterruptedException, IOException{
        Case[][] map = tab.getMap();
        while (block.getPosY() + 1 < map.length && !map[block.getPosY() + 1][block.getPosX()].isOccupe()){
            block.move(block.getPosX(), block.getPosY() + 1);
            Affichage.afficherTetris(tab, block);
            Thread.sleep(timeWait);
            int c = System.in.read();
            if (c == 'd' && block.getPosX()<9 && !map[block.getPosY()][block.getPosX() + 1].isOccupe()) {
                block.move(block.getPosX()+1, block.getPosY());
            }
            if (c == 'q' && block.getPosX()>0 && !map[block.getPosY()][block.getPosX() - 1].isOccupe()) {
                block.move(block.getPosX()-1, block.getPosY());
            }
            Affichage.clearScreen();
        }
        map[block.getPosY()][block.getPosX()].setOccupe(true);
    }*/

    public static void main(String[] args){
        Carte tab = new Carte();
        try{
            boolean isOn = true;
            while (Main.gameOver(tab)) {;
                Case block = new Case(5, 0, "██");
                getDown(block, tab);
            }
        } catch(InterruptedException ie){}
        catch(IOException ioe){}

        try{
            Affichage.afficherGameOver(tab);
        } catch (IOException e) {}

        Affichage.afficherPhrase("Appuyez sur"+ Affichage.ROUGE + " ENTER ⏎ " + Affichage.RESET+ "pour lancer une nouvelle partie", 2);



    }
}
