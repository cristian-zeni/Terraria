package data;

public class Map {

    private static final int DIM = 8;
    private Block[][] map;

    public Map(){
        map = new Block[DIM][DIM];
        for(int i = 0; i < DIM; i++){
            for(int j = 0; j < DIM; j++){
                map[i][j] = new Block();
            }
        }
    }

    public void change_cell(int row, int column){
        if (row >= DIM || column >= DIM){
            System.err.println("La cella richiesta è fuori dalla mappa");
        } else {
            this.map[row][column] = new Block('A');
        }
    }

    public void swap(){

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
