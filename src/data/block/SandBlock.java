package data.block;

public class SandBlock extends AbstractBlock{
    public SandBlock(){
        this.blockname = "Sabbia";
        this.contenuto = 'S';
        this.falls_with_gravity = true;
        this.fall_through = false;
    }
}
