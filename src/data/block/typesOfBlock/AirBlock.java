package data.block.typesOfBlock;

import data.block.AbstractBlock;

public class AirBlock extends AbstractBlock {

    public AirBlock(){
        this.contenuto = '.';
        this.falls_with_gravity = false;
        this.fall_through = true;
    }

}
