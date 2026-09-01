package tetris;

public class Case {
    private boolean occupe;

    public Case(){
        this.occupe = false;
    }

    public boolean isOccupe() {
        return occupe;
    }

    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    }
}
