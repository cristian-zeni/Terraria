package data.userInterface;

import data.block.Furnace;
import data.block.interfaces.SmeltableBlock;
import data.block.typesOfBlock.AirBlock;
import data.utility.Coordinate;
import data.utility.Factory;

public class MainView {
    private Map world;
    private Furnace fornace;
    private Factory factory;

    public MainView(){
        this.world = new Map();
        this.fornace = new Furnace();
        this.factory = new Factory();
    }

    public void move_into_furnace(Coordinate c){
        if(world.isSmeltable(c)){
            this.fornace.setInput((SmeltableBlock) world.getBlock(c));
            this.world.change_cell(c, factory.airBlock());
        }else{
            System.err.println("Blocco non smeltabile!");
        }
    }

    public void smelt(){
        this.fornace.smelt();
    }

    public void display_on_out(){
        this.world.display_on_out();
        this.fornace.display_on_out();

    }

}
