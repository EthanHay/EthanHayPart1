import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ethan on 13-Sep-16.
 */
/*
* Class that initialises all values for a new game
 */
public class initGame {
    ArrayList<initCard> deck;
    private static int numOfPlayers;

    public initGame(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public static void startGameLoop() {

    }

    public static class startGame{
        //loop material here, most of game logic
    }

    @Override
    public String toString() {
        return "initGame{}";
    }

    public static ArrayList<initCard> buildDeck() {
        ArrayList<initCard> deck = new initDeck().initDeck();
        return deck;
    }

//    public static void getNumOfPlayers() {
//
//    }

    public static int selectDealer(int numOfPlayers) {
        return new Random().nextInt(numOfPlayers);
    }


}


