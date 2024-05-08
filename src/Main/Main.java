package Main;

import data.Block;
import data.Map;

import java.util.Scanner;

public class Main {

    private static Map world;

    public static void main(String[] args){
        generate();
        test();
    }

    static void generate(){

        world = new Map();
        world.display_on_out();

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter row ");
            Scanner s = new Scanner(System.in);
            int row = s.nextInt();

            System.out.print("Enter column: ");
            int col = s.nextInt();

            System.out.println("Changing: " + row + " - " + col);
            world.change_cell(row, col);
            world.display_on_out();
        }
    }

    static void test(){
        Block n = new Block('S');
        //world.insert_at_coords(0,2, n);
        world.insert_iter(0,2, n);
        world.insert_rec(0,3,n);
        System.out.println();
        world.display_on_out();
    }

}   