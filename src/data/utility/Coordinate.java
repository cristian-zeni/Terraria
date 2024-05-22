package data.utility;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(){
        this(0,0);
    }

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    //Setter
    public void setX(int x) {
        this.x = x;
    }

    //Getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
