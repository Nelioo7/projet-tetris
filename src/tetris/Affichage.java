package tetris;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Affichage {
    
    public static void afficherTetris(Carte carte) throws IOException{

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader("res/affichage/ascii-art.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();
        System.out.println(sb.toString());
    }


}
// javac -d bin -cp bin src/tetris/*.java
// java -cp bin tetris.Main