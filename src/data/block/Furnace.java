package data.block;

import data.block.interfaces.Block;
import data.block.interfaces.SmeltableBlock;

public class Furnace {
    private SmeltableBlock input;
    private Block output;

    public Furnace(){
        this.input = new NullBlock();
        this.output = new NullBlock();
    }

    public void display_on_out(){
        System.out.println("|" + this.input.display() + "|--->|" + this.output.display() + "|");
    }

    public void smelt(){
        this.output = input.smelt();
        this.input = new NullBlock();
    }

    public void setInput(SmeltableBlock b){
        this.input = b;
        output = b.smelt();
    }

}
