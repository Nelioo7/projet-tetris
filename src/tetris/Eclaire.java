package tetris;

public class Eclaire extends Bloc {
        public Eclaire(Carte carte){
        this.setCases(new Case[4]);
        this.getCases()[0] = new Case(4, 0, "██");
        this.getCases()[1] = new Case(5, 0, "██");
        this.getCases()[2] = new Case(5, 1, "██");
        this.getCases()[3] = new Case(6, 1, "██");
        this.setMap(carte.getMap());
    }
}
