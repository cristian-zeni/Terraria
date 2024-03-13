package data;

public class Block {

    private char contenuto;
    private boolean falls_with_gravity;
    private boolean fall_through;

    public Block(){
        this.contenuto = '.';
        this.falls_with_gravity = false;
        this.fall_through = true;
    }

    public Block(char t){
        this.contenuto = t;
        this.falls_with_gravity = true;
        this.fall_through = false;
    }

    public boolean isGravityAffected(){
        return this.falls_with_gravity;
    }

    public boolean isSolid() {
        return this.fall_through;
    }

    public char display(){
        return this.contenuto;
    }

}
