package data.block;

public class CustomBlock extends AbstractBlock{
    public CustomBlock(char c){
        this.contenuto = c;
        this.falls_with_gravity = true;
        this.fall_through = false;
    }
}
