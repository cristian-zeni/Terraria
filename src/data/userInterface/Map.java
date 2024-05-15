package data.userInterface;

import data.block.AirBlock;
import data.block.Block;
import data.block.SandBlock;
import data.block.WaterBlock;

public class Map {

    private static final int DIM = 8;
    private Block[][] map;

    public Map(){
        map = new Block[DIM][DIM];
        for(int i = 0; i < DIM; i++){
            for(int j = 0; j < DIM; j++){
                map[i][j] = new AirBlock();
            }
        }
        addRiver();
    }

    public void change_cell(int row, int column) {
        if (row >= DIM || column >= DIM) {
            System.err.println("La cella richiesta è fuori dalla mappa");
        } else {
            this.map[row][column] = new SandBlock();
        }
    }

    private void swap(int x, int y){
        if(map[x+1][y].isNotSolid()){
            Block tmp = map[x+1][y];
            map[x+1][y] = map[x][y];
            map[x][y] = tmp;
        }else{
            System.err.println("Il blocco sotto è solido");
        }
    }

    /*public void insert_at_coords(int x, int y, Block b){
        if(x >= DIM || y >= DIM){
            System.err.println("La cella richiesta è fuori dalla mappa");
            return;
        }
        map[x][y] = b;
        if (map[x][y].isGravityAffected() && map[x+1][y].isNotSolid()){
            swap(x, y);
        }
    }*/

    public void insert_iter(int x, int y, Block b){
        if(x >= DIM || y >= DIM){
            System.err.println("La cella richiesta è fuori dalla mappa");
            return;
        }

        map[x][y] = b;

        if (!map[x][y].isGravityAffected()){
            return;
        }
        while(x+1 < DIM && map[x+1][y].isNotSolid()) {
            swap(x, y);
            x++;
        }
    }

    public void insert_rec(int x, int y, Block b){
        if(x < DIM && y < DIM){
            map[x][y] = b;
        }else{
            System.err.println("La cella richiesta è fuori dalla mappa");
            return;
        }

        if(x == DIM-1 || !map[x][y].isGravityAffected() || !map[x+1][y].isNotSolid()){
            return;
        }
        swap(x, y);
        insert_rec(x+1, y, b);

    }

    //Start of water methods
    private void addRowsOfWater(){
        WaterBlock a = new WaterBlock();
        for(int y = 0; y < DIM; y++){
            insert_rec(0, y, a);
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

    public void display_on_out(){
        for (int i = 0; i < DIM; i++){
            for (int j = 0; j < DIM; j++){
                System.out.print(map[i][j].display());
            }
            System.out.println();
        }
    }
}
