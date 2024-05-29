package data.block.interfaces;

public interface Block extends InventoryBlock{

    public boolean isGravityAffected();
    public boolean isNotSolid();
    public char display();

}
