import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ethan on 13-Sep-16.
 */
/*
* Class that initialises all values for a new game
 */
public class initGame {

    public initGame() {

    }
    public static class startGame{
        //loop material here, most of game logic
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

    public class XMLdata {

    }
}


