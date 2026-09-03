package tetris;

public class Case {
    private boolean occupe;
    private int posX;
    private int posY;
    private String shape;
    
    public Case(int posX, int posY, String shape){
        this.posX = posX;
        this.posY = posY;
        this.shape = shape;
        this.occupe = false;
    }

    public Case(){
        this(0, 0, "██");
    }

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }

    public String getShape(){
        return this.shape;
    }

    public boolean isOccupe() {
        return occupe;
    }

    public void move(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    public void setOccupe(boolean occupe) {
        this.occupe = occupe;
    }
}
