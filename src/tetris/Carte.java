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

    public void ligneASup(){
        boolean res = true;
        for(int i=0;i<this.map.length;i++){
            res = true;
            for(int j=0;j < this.map[i].length;j++){
                if (map[i][j].isOccupe() == false) {
                    res = false;
                }
            }
            if(res){
                supprimerLigne(i);
            }
        }
    }

    public int supprimerLigne(int ligne){
        for(int g=0; g<this.map[ligne].length; g++){
            map[ligne][g].setOccupe(false);
        }
        return ligne;
    }
}