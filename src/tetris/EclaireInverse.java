package tetris;

public class EclaireInverse extends Bloc {
        public EclaireInverse(Carte carte){

        int r = Bloc.rand.nextInt(0,6);
        this.setCouleur(this.randColor(r));

        this.setCases(new Case[4]);
        this.getCases()[0] = new Case(5, 0, this.getCouleur() + "██" + Affichage.RESET, this.getCouleur());
        this.getCases()[1] = new Case(6, 0, this.getCouleur() + "██" + Affichage.RESET, this.getCouleur());
        this.getCases()[2] = new Case(5, 1, this.getCouleur() + "██" + Affichage.RESET, this.getCouleur());
        this.getCases()[3] = new Case(4, 1, this.getCouleur() + "██" + Affichage.RESET, this.getCouleur());
        this.setMap(carte.getMap());
    }

    public void rotation(){
        if(this.getCases()[0].getPosY() == this.getCases()[1].getPosY()){
            this.getCases()[0].setPosY(this.getCases()[0].getPosY()+2);
            this.getCases()[3].setPosX(this.getCases()[3].getPosX()+2);
        }
        else{
            this.getCases()[0].setPosY(this.getCases()[0].getPosY()-2);
            this.getCases()[3].setPosX(this.getCases()[3].getPosX()-2);
        }
    }

    public boolean peutTourner(){
        if(this.getCases()[0].getPosY() == this.getCases()[1].getPosY()){
            return this.getCases()[0].getPosY() < 23;  
        }
        else{
            return this.getCases()[1].getPosX() > 1;
        }
    }
}
