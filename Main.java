/**
 * Created by Ethan on 13-Sep-16.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args){

        String Start = "";
        Scanner input = new Scanner(System.in);


        System.out.println("Welcome to Mineral SuperTrumps!");
        System.out.println("Do you wish to start a new game? \nY/N\n");

        Start = input.next();
        Start = Start.toUpperCase();

        //validate input
        while (!(Start.equals("Y") || Start.equals("N") || Start.equals("E"))) {
            System.out.println("The value entered is invalid...");
            System.out.print("Do you wish to start a new game?  or (E)xit \nY/N\n");
            Start = input.next();
            Start = Start.toUpperCase();
        }

        //double check input and act on input
        if (Start.equals("Y") || Start.equals("N")) {
            if (Start.equals("Y")) {
                //Start game
                System.out.printf("Start = " + Start);
            } else {
                //go back to menu/ ask to continue/load game
                System.out.printf("Start = " + Start);
            }
        } else if (Start.equals("E")){
            //exit application
            System.out.printf("Closing Application...");
        }
        initPlayer.createPlayer("help");
    }
}
