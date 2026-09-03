package tetris;

public class Barre extends Bloc {
        public Barre(Carte carte){
        int r = Bloc.rand.nextInt(0,6);
        this.setCouleur(this.randColor(r));

        this.setCases(new Case[4]);
        this.getCases()[0] = new Case(3, 0, this.getCouleur() + "██" + Affichage.RESET, this.getCouleur());
        this.getCases()[1] = new Case(4, 0, this.getCouleur() + "██" + Affichage.RESET, this.getCouleur());
        this.getCases()[2] = new Case(5, 0, this.getCouleur() + "██" + Affichage.RESET, this.getCouleur());
        this.getCases()[3] = new Case(6, 0, this.getCouleur() + "██" + Affichage.RESET, this.getCouleur());
        this.setMap(carte.getMap());
    }

    public void rotation(){
        System.out.println("dans rotation");
        if(this.getCases()[0].getPosY() == this.getCases()[1].getPosY()){
            this.getCases()[0].setPosX(this.getCases()[0].getPosX()+1);
            this.getCases()[0].setPosY(this.getCases()[0].getPosY()-1);
            this.getCases()[2].setPosX(this.getCases()[2].getPosX()-1);
            this.getCases()[2].setPosY(this.getCases()[2].getPosY()+1);
            this.getCases()[3].setPosX(this.getCases()[3].getPosX()-2);
            this.getCases()[3].setPosY(this.getCases()[3].getPosY()+2);
        }
        else{
            this.getCases()[0].setPosX(this.getCases()[0].getPosX()-1);
            this.getCases()[0].setPosY(this.getCases()[0].getPosY()+1);
            this.getCases()[2].setPosX(this.getCases()[2].getPosX()+1);
            this.getCases()[2].setPosY(this.getCases()[2].getPosY()-1);
            this.getCases()[3].setPosX(this.getCases()[3].getPosX()+2);
            this.getCases()[3].setPosY(this.getCases()[3].getPosY()-2);
        }
    }

    public boolean peutTourner(){
        if(this.getCases()[0].getPosY() == this.getCases()[1].getPosY()){
            return this.getCases()[0].getPosY() < 22 && this.getCases()[0].getPosY() > 1;
        }
        else{
            return this.getCases()[0].getPosX() > 1 && this.getCases()[0].getPosX() < 8;
        }
    }
}
