package Main;

import data.userInterface.MainView;
import data.utility.Coordinate;

import java.util.Scanner;

public class Main {

    private static MainView view;

    public static void main(String[] args){
        generate();
        test(5);
    }

    static void generate(){

        view = new MainView();
        view.display_on_out();

    }

    static void test(int interactions){
        for (int i = 0 ; i < interactions ; i++){
            System.out.print("Enter row and then column, or enter '9' and then '9' for smelting: ");
            Scanner s = new Scanner(System.in);
            int row = s.nextInt();
            int col = s.nextInt();
            if (row == 9 && col == 9){
                view.smelt();
            }else{
                Coordinate c = new Coordinate(row, col);
                view.move_into_furnace(c);
            }
            view.display_on_out();
        }
    }

}   