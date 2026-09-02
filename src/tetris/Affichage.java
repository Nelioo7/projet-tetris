package tetris;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Affichage {
    
    public static void afficherTetris(Carte carte, Case block) throws IOException{
        
        BufferedReader br = new BufferedReader(new FileReader("res/affichage/ascii-art.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
        
        Case[][] map = carte.getMap();
        for (int y=0; y < map.length; y++){
            StringBuilder sb = new StringBuilder();
            sb.append("                                     █");
            for (int x=0 ; x < map[0].length; x++) {
                if ( x == block.getPosX() && y == block.getPosY()){
                    sb.append(block.getShape());
                }else if (map[y][x].isOccupe()) {
                    sb.append("██");
                }else{
                    sb.append("  ");
                }
            }
            sb.append("█");
            System.out.println(sb.toString());
        }
        System.out.println("                                     ██████████████████████");
    }
}