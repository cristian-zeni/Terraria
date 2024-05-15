package data.block;

public class WaterBlock extends AbstractBlock{
    public WaterBlock(){
        this.blockname = "Water";
        this.contenuto = '~';
        this.falls_with_gravity = true;
        this.fall_through = true;
    }
}
