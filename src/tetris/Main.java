package tetris;

import java.io.IOException;

public class Main {
    
    static long timeWait = 250;
    
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
        }
        map[block.getPosY()][block.getPosX()].setOccupe(true);
    }*/

    public static void main(String[] args){
        Carte tab = new Carte();
        try{
            boolean isOn = true;
            while (isOn) {
                Carre carre = new Carre(tab);
                carre.getDown(tab);
                for (int i=0 ; i<carre.getCases().length ; i++){
                    carre.getMap()[carre.getCases()[i].getPosY()][carre.getCases()[i].getPosX()].setOccupe(true);
                }
            }
        } catch(InterruptedException ie){}
        catch(IOException ioe){}

    }
}
