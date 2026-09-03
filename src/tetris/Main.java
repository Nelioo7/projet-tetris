package tetris;

import java.io.IOException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.terminal.Terminal.Signal;
import org.jline.utils.NonBlockingReader;

// javac -d bin -cp bin:lib/jline-4.3.1.jar src/tetris/*.java
// java -cp bin:lib/jline-4.3.1.jar tetris.Main

public class Main {
    
    static long timeOut = 500;

    public static boolean gameOver(Carte tab) {
        for(int i = 0; i < tab.getMap()[0].length; i++) {
            if(tab.getMap()[0][i].isOccupe()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        Carte tab = new Carte();

        Terminal t = TerminalBuilder.builder().dumb(true).build();
        t.enterRawMode();

        try{
            while (Main.gameOver(tab)) {
                Bloc block = new Carre(tab);
                block.getDown(tab, t);
                for (int i=0 ; i<block.getCases().length ; i++){
                    block.getMap()[block.getCases()[i].getPosY()][block.getCases()[i].getPosX()].setOccupe(true);
                }
                tab.ligneASup();
            }
        } catch(InterruptedException ie){}
        catch(IOException ioe){}
        
        try{
            Affichage.clearScreen();
            Affichage.afficherGameOver(tab);
        } catch (IOException e) {}

        Affichage.afficherPhrase("Appuyez sur"+ Affichage.ROUGE + " ENTER ⏎ " + Affichage.RESET+ "pour lancer une nouvelle partie", 2);



    }
}
