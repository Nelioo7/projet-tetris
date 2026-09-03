package tetris;

import java.io.IOException;
import java.util.Random;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.terminal.Terminal.Signal;
import org.jline.utils.NonBlockingReader;

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

    public static void jouerPartie(Carte tab, Terminal t, Random r) throws InterruptedException, IOException {
        while (Main.gameOver(tab)) {
            Bloc[] blocs = new Bloc[]{new Barre(tab), new Carre(tab), new Eclaire(tab), new EclaireInverse(tab), new L(tab), new Linverse(tab), new T(tab)};
            int idx = r.nextInt(0,7);
            blocs[idx].getDown(tab, t);
            for (int i=0 ; i<blocs[idx].getCases().length ; i++){
                Case caseCarte = blocs[idx].getMap()[blocs[idx].getCases()[i].getPosY()][blocs[idx].getCases()[i].getPosX()];
                caseCarte.setOccupe(true);
                caseCarte.setCouleur(blocs[idx].getCases()[i].getCouleur());
            }
            tab.ligneASup();
        }
    }

    public static void main(String[] args) throws IOException{
        Random r = new Random();
        Terminal t = TerminalBuilder.builder().dumb(true).build();
        t.enterRawMode();
        NonBlockingReader reader = t.reader();
        boolean rejouer = true;

        while (rejouer) {
            Carte tab = new Carte();
            try {
                jouerPartie(tab, t, r);
            } catch(InterruptedException ie){}
            catch(IOException ioe){}
            try{
                Affichage.clearScreen();
                Affichage.afficherGameOver(tab);
            } catch (IOException e) {}
            Affichage.afficherPhrase("Appuyez sur"+ Affichage.ROUGE + " ENTER ⏎ " + Affichage.RESET+ "pour lancer une nouvelle partie, ou " + Affichage.ROUGE + "ECHAP" + Affichage.RESET + " pour quitter", 2);

            rejouer = false;
            while (true) {
                int c = reader.read();
                if (c == 27) { // ESC = 27 dans le tableau ASCII
                    rejouer = false;
                    break;
                }
                if (c == 13 || c == 10) { // Entrée = 13 ou 10 dans le tableau ASCII
                    rejouer = true;
                    break;
                }
            }
        }

        System.exit(0);
    }
}

// javac -d bin -cp bin:lib/jline-4.3.1.jar src/tetris/*.java
// java -cp bin:lib/jline-4.3.1.jar tetris.Main
