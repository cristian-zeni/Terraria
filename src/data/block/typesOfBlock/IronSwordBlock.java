package data.block.typesOfBlock;

import data.block.AbstractSolidBlock;
import data.block.interfaces.IronSwordInterface;

public class IronSwordBlock extends AbstractSolidBlock implements IronSwordInterface {
    protected IronSwordBlock(){
        super();
        this.blockname = "Spada in Ferro";
        this.contenuto = 'K';
    }
}
