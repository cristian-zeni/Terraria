package data.block.interfaces;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock{
    @Override
    public NullBlock smelt() {
        return new NullBlock();
    }
}
