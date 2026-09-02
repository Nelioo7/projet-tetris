package tetris;

public class L extends Bloc {
        public L(Carte carte){
        this.setCases(new Case[4]);
        this.getCases()[0] = new Case(5, 0, "██");
        this.getCases()[1] = new Case(5, 1, "██");
        this.getCases()[2] = new Case(5, 2, "██");
        this.getCases()[3] = new Case(6, 2, "██");
        this.setMap(carte.getMap());
    }
}
