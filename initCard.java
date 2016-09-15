import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ethan on 15-Sep-16.
 */
public class initCard {
    //define all global variables
    public int cardHardness, cardId;
    public float cardGravity;
    public ArrayList<Integer> cardCleavageValue;
    public ArrayList<String> cardCleavageCondition;
    public String cardCrustalAbundance;
    public String cardEconomicValue;

    public initCard(int cardIndex){
        this.cardId = cardIndex;
        this.cardHardness = new Random().nextInt(10);
        this.cardGravity = 1;
    }

}
