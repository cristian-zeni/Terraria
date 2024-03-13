package Main;

import data.Map;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        generate();
    }

    static void generate(){

        Map world = new Map();
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
}