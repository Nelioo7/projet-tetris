package tetris;

public class T extends Bloc {
        public T(Carte carte){
        this.setCases(new Case[4]);
        this.getCases()[0] = new Case(4, 0, this.getCouleur() + "██" + Affichage.RESET, this.getCouleur());
        this.getCases()[1] = new Case(5, 0,this.getCouleur() + "██" + Affichage.RESET, this.getCouleur());
        this.getCases()[2] = new Case(6, 0,this.getCouleur() + "██" + Affichage.RESET, this.getCouleur());
        this.getCases()[3] = new Case(5, 1, this.getCouleur() + "██" + Affichage.RESET, this.getCouleur());
        this.setMap(carte.getMap());
    }
}
