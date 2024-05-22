package data.block.interfaces;

import data.block.AbstractBlock;

public class AbstractSolidBlock extends AbstractBlock {
    public AbstractSolidBlock(){
        this.falls_with_gravity = false;
        this.fall_through = false;
    }
}
