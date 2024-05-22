package data.block.typesOfBlock;

import data.block.AbstractBlock;
import data.block.interfaces.Block;
import data.block.interfaces.SmeltableBlock;

public class SandBlock extends AbstractBlock implements SmeltableBlock {
    public SandBlock(){
        this.blockname = "Sabbia";
        this.contenuto = 'S';
        this.falls_with_gravity = true;
        this.fall_through = false;
    }

    public Block smelt(){
        return new GlassBlock();
    }
}
