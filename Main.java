/**
 * Created by Ethan on 13-Sep-16.
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args){

        String start, players;
        int numOfPlayers;

        Scanner input = new Scanner(System.in);


        System.out.println("Welcome to Mineral SuperTrumps!");
        System.out.println("Do you wish to start a new game? \nY/N\n");

        start = input.next();
        start = start.toUpperCase();

        //validate input
        while (!(start.equals("Y") || start.equals("N") || start.equals("E"))) {
            System.out.println("The value entered is invalid...");
            System.out.print("Do you wish to start a new game?  or (E)xit \nY/N\n");
            start = input.next();
            start = start.toUpperCase();
        }

        //double check input and act on input
        if (start.equals("Y") || start.equals("N")) {
            if (start.equals("Y")) {
                //Start game
                System.out.println("Start = " + start);
                System.out.println("Building new deck...");

                initGame.buildDeck();

                System.out.println("How many bots do you want to verse? (2 - 9)");
                players = input.next();

                //check players input
                while (Integer.parseInt(players) < 2 || Integer.parseInt(players) > 9) {
                    System.out.println("Please enter a valid number...");
                    System.out.println("How many bots do you want to verse? (2 - 9)");
                    players = input.next();
                }
                numOfPlayers = Integer.parseInt(players);

                System.out.println(numOfPlayers);
                /*
                for (int i = 0; i < numOfPlayers; i++){
                    initPlayer.createPlayer(i);
                }
                */

            } else {
                //go back to menu/ ask to continue/load game
                System.out.printf("Start = " + start);
            }
        } else if (start.equals("E")){
            //exit application
            System.out.printf("Closing Application...");
        }
    }
}
