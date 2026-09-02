package tetris;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.*;

public class Main {
    
    static long timeWait = 250;
    
    public static void getDown(Case block, Carte tab) throws InterruptedException, IOException{
        Case[][] map = tab.getMap();
        while (block.getPosY() + 1 < map.length && !map[block.getPosY() + 1][block.getPosX()].isOccupe()){
            block.move(block.getPosX(), block.getPosY() + 1);
            Affichage.afficherTetris(tab, block);
            Thread.sleep(timeWait);
            
        }
        map[block.getPosY()][block.getPosX()].setOccupe(true);;
    }

    public static void main(String[] args){
        Carte tab = new Carte();

        try{
            boolean isOn = true;
            while (isOn) {
                Case block = new Case(5, 0, "██");
                getDown(block, tab);
            }
        } catch(InterruptedException ie){}
        catch(IOException ioe){}

    }
}
