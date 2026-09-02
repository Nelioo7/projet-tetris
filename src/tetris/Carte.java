package tetris;

public class Carte {
    private Case[][] map;

    public Carte(){
        this.map = new Case[24][10];
        for (int y=0 ; y < 24 ; y++){
            for (int x=0 ; x < 10 ; x++){
                this.map[y][x] = new Case();
            }
        }
    }

    public Case[][] getMap(){
        return this.map;
    }


}