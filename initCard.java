import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ethan on 15-Sep-16.
 */
public class initCard {
    //define all global variables
    public int cardId;
    public ArrayList cardData;

    public initCard(ArrayList cardData){
        this.cardData = cardData;
    }

    public String toString() {
        return "CardID = " + cardId;
    }

//Doesnt work how i thought it would
//    public ArrayList<String> toArray() {
//        ArrayList<String> ret = new ArrayList<>();
//        ret.add(Integer.toString(cardId));
//        ret.add(Integer.toString(cardHardness));
//
//        return ret;
//    }
}
