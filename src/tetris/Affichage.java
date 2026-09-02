package tetris;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class Affichage {
    
    public static final String RESET = "\u001B[0m";
    public static final String ROUGE = "\u001B[31m";
    public static final String BLEU   = "\u001B[34m";
    public static final String VERT = "\u001B[32m";
    public static Random rand = new Random();

    public static void afficherTetris(Carte carte, Case block) throws IOException{
        
        BufferedReader br = new BufferedReader(new FileReader("res/affichage/ascii-art.txt"));
        StringBuilder s = new StringBuilder();
        int c;  
        while ((c = br.read()) != -1) {
            if(Affichage.rand.nextInt(10) >= 4 ) {
                s.append(Affichage.VERT);
            } else {
                s.append(Affichage.ROUGE);
            }
           s.append((char) c);
            // if(Affichage.rand.nextInt(10) >= 4 ) {
            //     s.append(Affichage.RESET);
            // } 
        }
        br.close();
        s.append(Affichage.RESET);
        System.out.println(s);

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

    public static void afficherGameOver(Carte carte) throws IOException{
        
        BufferedReader br = new BufferedReader(new FileReader("res/affichage/GameOver.txt"));
        String line;
        System.out.println(Affichage.ROUGE);
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println(Affichage.RESET);
        br.close();
        
        Case[][] map = carte.getMap();
        for (int y=0; y < map.length; y++){
            StringBuilder sb = new StringBuilder();
            sb.append("                                     █");
            for (int x=0 ; x < map[0].length; x++) {
                if (map[y][x].isOccupe()) {
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

    public static void clearScreen() { 
        System.out.print("\033[H\033[J");
    }


    public static void afficherPhrase(String phrase, int n) {
        int i = 0;
            while (i < phrase.length()) {
                if (phrase.charAt(i) == '\u001B') {
                    // on a trouvé le début d'un code couleur, on cherche son 'm' de fin
                    int fin = phrase.indexOf('m', i);
                    System.out.print(phrase.substring(i, fin + 1));
                    i = fin + 1;
                } else {
                    // caractère normal
                    System.out.print(phrase.charAt(i));
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {}
                    i++;
                }
            }
        for(int counter = 1; counter <= n; counter++) {
            System.out.println("");
        }
    }

}