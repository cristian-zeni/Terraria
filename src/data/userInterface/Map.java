package data.userInterface;

import data.block.interfaces.SmeltableBlock;
import data.block.typesOfBlock.AirBlock;
import data.block.interfaces.Block;
import data.block.typesOfBlock.RawIronBlock;
import data.block.typesOfBlock.SandBlock;
import data.block.typesOfBlock.WaterBlock;
import data.utility.Coordinate;
import data.utility.Factory;

import java.util.Random;

public class Map {

    private static final int DIM = 8;
    private Block[][] map;
    private Factory factory;

    public Map(){
        this.factory = new Factory();
        map = new Block[DIM][DIM];
        for(int i = 0; i < DIM; i++){
            for(int j = 0; j < DIM; j++){
                map[i][j] = factory.airBlock();
            }
        }
        popolate(15, 3);
    }

    //Start insert block methods
    public void change_cell(Coordinate c, Block b) {
        if (!coordBound(c)) {
            System.err.println("La cella richiesta è fuori dalla mappa");
        } else {
            this.map[c.getX()][c.getY()] = b;
        }
    }

    public void popolate(int solid, int water){
        Random rand = new Random();
        for (int i = 0 ; i < solid; i++){
            int type = rand.nextInt(2);
            Block b;
            if(type == 0){
                b = factory.sand_block();
            }else{
                b = factory.rawIronBlock();
            }
            int row = rand.nextInt(DIM);
            int col = rand.nextInt(DIM);
            Coordinate c = new Coordinate(row, col);
            insert_rec(c, b);
        }
        for(int i = 0; i < water; i++){
            addRiver();
        }
    }

    public void insert_iter(Coordinate c, Block b){
        if(coordBound(c)){
            System.err.println("La cella richiesta è fuori dalla mappa");
            return;
        }

        map[c.getX()][c.getY()] = b;

        if (!map[c.getX()][c.getY()].isGravityAffected()){
            return;
        }
        while(c.getX()+1 < DIM && map[c.getX()+1][c.getY()].isNotSolid()) {
            swap(c);
            c.setX(c.getX()+1);
        }
    }

    public void insert_rec(Coordinate c, Block b){
        if(coordBound(c)){
            map[c.getX()][c.getY()] = b;
        }else{
            System.err.println("La cella richiesta è fuori dalla mappa");
            return;
        }

        if(c.getX() == DIM-1 || !map[c.getX()][c.getY()].isGravityAffected() || !map[c.getX()+1][c.getY()].isNotSolid()){
            return;
        }
        swap(c);
        c.setX(c.getX()+1);
        insert_rec(c, b);

    }


    //End insert block

    //Start physics method
    private void swap(Coordinate c){
        if(map[c.getX()+1][c.getY()].isNotSolid()){
            Block tmp = map[c.getX()+1][c.getY()];
            map[c.getX()+1][c.getY()] = map[c.getX()][c.getY()];
            map[c.getX()][c.getY()] = tmp;
        }else{
            System.err.println("Il blocco sotto è solido");
        }
    }

    //End physics method

    //Start of water methods
    private void addRowsOfWater(){
        WaterBlock a = factory.waterBlock();
        for(int y = 0; y < DIM; y++){
            Coordinate c = new Coordinate(0, y);
            insert_rec(c, a);
        }
    }

    public void addRiver(){
        addRowsOfWater();
    }
    public void addSea(){
        for(int i = 0; i < 3; i++){
            addRowsOfWater();
        }
    }

    //End of water methods

    //Start of control methods
    public boolean isSmeltable(Coordinate c){
        if(map[c.getX()][c.getY()] instanceof SmeltableBlock){
            return true;
        }else{
            return false;
        }
    }

    public Block getBlock(Coordinate c){
        return map[c.getX()][c.getY()];
    }

    private boolean coordBound(Coordinate c){
        if(c.getX() >= DIM || c.getY() >= DIM){
            return false;
        }
        return true;
    }

    //End of control methods

    public void display_on_out(){
        for (int i = 0; i < DIM; i++){
            for (int j = 0; j < DIM; j++){
                System.out.print(map[i][j].display());
            }
            System.out.println();
        }
    }
}
