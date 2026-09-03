package tetris;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Writer {
    
    private final Scanner sc = new Scanner(System.in);

    public String demanderNomDuJoeur() {
        String choix;
        Affichage.clearScreen();
        Affichage.afficherPhrase("Entrer votre nom puis appuyez sur" +Affichage.ROUGE+ " ENTER  ⏎ : " + Affichage.RESET, 0);

        choix = sc.nextLine();

        return choix;
    }

    public static void ecrireLeaderboard() throws IOException{
        
        // Lecture du leaderboard
        BufferedReader br = new BufferedReader(new FileReader("res/leaderboard/leaderboard.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        System.out.println(Affichage.RESET);
        
        System.out.println(Affichage.ROUGE);
        br.close();

    }


}
