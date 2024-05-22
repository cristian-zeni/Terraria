package data.block;

import data.block.interfaces.Block;

public abstract class AbstractBlock implements Block {
    public char contenuto;
    public String blockname;
    public boolean falls_with_gravity;
    public boolean fall_through;
    public boolean isGravityAffected(){
        return this.falls_with_gravity;
    }

    public boolean isNotSolid() {
        return this.fall_through;
    }

    public char display(){
        return this.contenuto;
    }

    @Override
    public String toString(){
        return "Nome: " + blockname + "; Gravità" + falls_with_gravity + "; Solido: " + !fall_through;
    }

}
