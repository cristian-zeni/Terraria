package data.userInterface;

import data.block.AbstractBlock;
import data.block.AirBlock;
import data.block.CustomBlock;

public class Map {

    private static final int DIM = 8;
    private AbstractBlock[][] map;

    public Map(){
        map = new AirBlock[DIM][DIM];
        for(int i = 0; i < DIM; i++){
            for(int j = 0; j < DIM; j++){
                map[i][j] = new AirBlock();
            }
        }
    }

    public void change_cell(int row, int column) {
        if (row >= DIM || column >= DIM) {
            System.err.println("La cella richiesta è fuori dalla mappa");
        } else {
            this.map[row][column] = new CustomBlock('A');
        }
    }

    private void swap(int x, int y){
        if(map[x+1][y].isNotSolid()){
            AbstractBlock tmp = map[x+1][y];
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

    public void insert_iter(int x, int y, CustomBlock b){
        if(x >= DIM || y >= DIM){
            System.err.println("La cella richiesta è fuori dalla mappa");
            return;
        }

        map[x][y] = b;

        while(map[x+1][y].isNotSolid() && x+1 < DIM) {
            if (map[x][y].isGravityAffected()) {
                swap(x, y);
            }
            x++;
        }
    }

    public void insert_rec(int x, int y, CustomBlock b){
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

    public void display_on_out(){
        for (int i = 0; i < DIM; i++){
            for (int j = 0; j < DIM; j++){
                System.out.print(map[i][j].display());
            }
            System.out.println();
        }
    }
}
