package data.block.typesOfBlock;

import data.block.AbstractSolidBlock;
import data.block.interfaces.Block;
import data.block.interfaces.SmeltableBlock;

public class RawIronBlock extends AbstractSolidBlock implements SmeltableBlock {

    public RawIronBlock(){
        super();
        this.blockname = "Ferro Grezzo";
        this.contenuto = 'I';
    }

    @Override
    public Block smelt() {
        return new IronSwordBlock();
    }
}
