package tetris;

public class Linverse extends Bloc {
        public Linverse(Carte carte){
        this.setCases(new Case[4]);
        this.getCases()[0] = new Case(5, 0, "██");
        this.getCases()[1] = new Case(5, 1, "██");
        this.getCases()[2] = new Case(5, 2, "██");
        this.getCases()[3] = new Case(4, 2, "██");
        this.setMap(carte.getMap());
    }

    public void rotation(){
        if(this.getCases()[0].getPosX() != this.getCases()[1].getPosX() && this.getCases()[0].getPosY() < this.getCases()[3].getPosY()){
            this.getCases()[0].setPosY(this.getCases()[0].getPosY()+1);
            this.getCases()[0].setPosX(this.getCases()[0].getPosX()+1);
            this.getCases()[2].setPosY(this.getCases()[2].getPosY()-1);
            this.getCases()[2].setPosX(this.getCases()[2].getPosX()-1);
            this.getCases()[3].setPosY(this.getCases()[3].getPosY()-2);
        }
        else if(this.getCases()[0].getPosX() == this.getCases()[1].getPosX() && this.getCases()[0].getPosY() < this.getCases()[3].getPosY()){
            this.getCases()[0].setPosY(this.getCases()[0].getPosY()+1);
            this.getCases()[0].setPosX(this.getCases()[0].getPosX()-1);
            this.getCases()[2].setPosY(this.getCases()[2].getPosY()-1);
            this.getCases()[2].setPosX(this.getCases()[2].getPosX()+1);
            this.getCases()[3].setPosX(this.getCases()[3].getPosX()+2);
        }
        else if(this.getCases()[0].getPosX() != this.getCases()[1].getPosX() && this.getCases()[0].getPosY() > this.getCases()[3].getPosY()){
            this.getCases()[0].setPosY(this.getCases()[0].getPosY()-1);
            this.getCases()[0].setPosX(this.getCases()[0].getPosX()-1);
            this.getCases()[2].setPosY(this.getCases()[2].getPosY()+1);
            this.getCases()[2].setPosX(this.getCases()[2].getPosX()+1);
            this.getCases()[3].setPosY(this.getCases()[3].getPosY()+2);
        }
        else if(this.getCases()[0].getPosX() == this.getCases()[1].getPosX() && this.getCases()[0].getPosY() > this.getCases()[3].getPosY()){
            this.getCases()[0].setPosY(this.getCases()[0].getPosY()-1);
            this.getCases()[0].setPosX(this.getCases()[0].getPosX()+1);
            this.getCases()[2].setPosY(this.getCases()[2].getPosY()+1);
            this.getCases()[2].setPosX(this.getCases()[2].getPosX()-1);
            this.getCases()[3].setPosX(this.getCases()[3].getPosX()-2);
        }
    }

    public boolean peutTourner(){
        if(this.getCases()[0].getPosX() == this.getCases()[1].getPosX() && this.getCases()[0].getPosY() < this.getCases()[3].getPosY()){
            return this.getCases()[0].getPosX() < 9;
        }
        else if(this.getCases()[0].getPosX() != this.getCases()[1].getPosX() && this.getCases()[0].getPosY() < this.getCases()[3].getPosY()){
            return this.getCases()[0].getPosY() < 23;
        }
        else if(this.getCases()[0].getPosX() == this.getCases()[1].getPosX() && this.getCases()[0].getPosY() > this.getCases()[3].getPosY()){
            return this.getCases()[0].getPosX() > 1;
        }
        else{
            return this.getCases()[0].getPosY() > 1;
        }
    }
}
