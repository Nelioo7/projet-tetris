package tetris;

import java.io.IOException;

import org.jline.terminal.Terminal;
import org.jline.utils.NonBlockingReader;

public abstract class Bloc {
    private final static long timeOut = 100;
    private Case[] cases;
    private Case[][] map;

    public void getDown(Carte carte, Terminal t) throws InterruptedException, IOException{

        NonBlockingReader reader = t.reader();

        while (this.peutDescendre()){
            Affichage.clearScreen();
            Affichage.afficherTetris(carte, this);
            // Thread.sleep(TIMEWAIT);
            // this.descendre();

            // Lecture clavier pendant maximum 500 ms
            int c = reader.read(timeOut);
            // stopper le soft
            if (c == 27) System.exit(0); // ESC = 27 dans le tableau ASCII


            if( c == 'q'  && this.peutAllerAGauche() || c == 'd' && this.peutAllerADroite() || c == ' ' && this.peutTourner()) {
                this.deplacement((char) c);
            }else {
                this.descendre();
            }
        }
    }

    public boolean peutDescendre(){
        boolean res = true;
        for(int i=0;i<4;i++){
            if (!(this.cases[i].getPosY() + 1<this.map.length) || this.map[this.cases[i].getPosY() + 1][this.cases[i].getPosX()].isOccupe()) {
                res = false;
            }
        }
        return res;
    }

    public void descendre(){
        for(int i=0;i<4;i++){
            this.cases[i].move(this.cases[i].getPosX(), this.cases[i].getPosY() + 1);
        }
    }

    public void deplacement(char c){
        if(c == 'd' && peutAllerADroite()){
            for(int i=0;i<4;i++){
                this.cases[i].move(this.cases[i].getPosX()+1, this.cases[i].getPosY());
            }
        }
        if(c == 'q' && peutAllerAGauche()){
            for(int i=0;i<4;i++){
                this.cases[i].move(this.cases[i].getPosX()-1, this.cases[i].getPosY());
            }
        }
        if(c == 's' && peutDescendre()){
            for(int i=0;i<4;i++){
                descendre();
            }
        }
        if(c == ' '){
            rotation();
        }
    }

    public boolean peutAllerADroite(){
        boolean res = true;
        for(int i=0;i<4;i++){
            if (!(this.cases[i].getPosX() < 9) || this.map[this.cases[i].getPosY()][this.cases[i].getPosX() + 1].isOccupe()) {
                res = false;
            }
        }
        return res;
    }

    public boolean peutAllerAGauche(){
        boolean res = true;
        for(int i=0;i<4;i++){
            if (!(this.cases[i].getPosX() > 0) || this.map[this.cases[i].getPosY()][this.cases[i].getPosX() - 1].isOccupe()) {
                res = false;
            }
        }
        return res;
    }

    public abstract boolean peutTourner();

    public Case[] getCases() {
        return cases;
    }

    public Case[][] getMap() {
        return map;
    }

    public void setCases(Case[] cases) {
        this.cases = cases;
    }

    public void setMap(Case[][] map) {
        this.map = map;
    }

    public abstract void rotation();
}
