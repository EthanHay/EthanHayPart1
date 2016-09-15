import java.util.ArrayList;

/**
 * Created by Ethan on 13-Sep-16.
 */
/*
* Class that initialises an individual player
 */
public class initPlayer {



    private ArrayList<initCard> cards;
    private String playerId;

    public initPlayer(String playerId) {
        this.playerId = playerId;
    }

    public void setCards(ArrayList<initCard> cards) {
        this.cards = cards;
    }

    public String toString() {
        return "PlayerID = " + playerId;
    }

    public static void createPlayer(int playerNumber) {
        System.out.println(playerNumber);
    }
}
