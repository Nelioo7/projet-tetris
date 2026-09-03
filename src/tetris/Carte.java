package tetris;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<this.map.length;i++){
            res = true;
            for(int j=0;j < this.map[i].length;j++){
                if (map[i][j].isOccupe() == false) {
                    res = false;
                }
            }
            if(res){
                supprimerLigne(i);
                l.add(i);
            }
        }
        actualiserLigne(l);
    }

    public int supprimerLigne(int ligne){
        for(int g=0; g<this.map[ligne].length; g++){
            map[ligne][g].setOccupe(false);
        }
        return ligne;
    }

    public void actualiserLigne(List<Integer> l){
        for(int j=0;j<l.size();j++){
            for(int i=this.map.length-1;i>0;i--){
                for(int k=0;k<this.map[i].length;k++){
                    if(l.get(j)>=i && this.map[i-1][k].isOccupe()){
                        this.map[i][k].setOccupe(true);//.setPosY(this.map[i][k].getPosY()+1);
                        this.map[i-1][k].setOccupe(false);
                    }
                    
                }

            }
        }
    }
}