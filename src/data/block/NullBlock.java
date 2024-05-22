package data.block;

import data.block.interfaces.Block;
import data.block.interfaces.SmeltableBlock;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {
    @Override
    public Block smelt() {
        return new NullBlock();
    }
}
