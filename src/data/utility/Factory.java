package data.utility;

import data.block.typesOfBlock.AirBlock;
import data.block.typesOfBlock.RawIronBlock;
import data.block.typesOfBlock.SandBlock;
import data.block.typesOfBlock.WaterBlock;

public class Factory {

    public AirBlock airBlock(){
        return new AirBlock();
    }

    public SandBlock sand_block(){
        return new SandBlock();
    }

    public WaterBlock waterBlock(){
        return new WaterBlock();
    }

    public RawIronBlock rawIronBlock(){
        return new RawIronBlock();
    }
}
