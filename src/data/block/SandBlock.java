package data.block;

import data.block.interfaces.SmeltableBlock;

public class SandBlock extends AbstractBlock implements SmeltableBlock {
    public SandBlock(){
        this.blockname = "Sabbia";
        this.contenuto = 'S';
        this.falls_with_gravity = true;
        this.fall_through = false;
    }

    public AbstractBlock smelt(){
        return new SandBlock();
    }
}
