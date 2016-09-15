import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ethan on 15-Sep-16.
 */
public class initDeck {
    private static final int NUM_CARDS_INIT = 53; //this is the highest amount, add fail-safe later.  54 predefined cards, 53 + zero index
    public ArrayList<initCard> cards;

    public ArrayList<initCard> initDeck() {
        String rawContent;
        cards = new ArrayList<>();
        {
            try {

                File fXmlFile = new File("src/MstCards_151021.plist");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                doc.getDocumentElement().normalize();

                for (int i = 0; i < NUM_CARDS_INIT; i++) {
                    rawContent = doc.getElementsByTagName("dict").item(i).getTextContent();
                    if (i == 0){
                        //cut off unnecessary "cards" string before processing
                        rawContent = rawContent.substring(5);
                    }

                    System.out.println("Card"+ i +" : " + rawContent);
                    cards.add(new initCard(i));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cards;
    }

    public ArrayList<initCard> dealCards(int nCards) {
        ArrayList<initCard> ret = new ArrayList<initCard>();
        for (int i = 0; i < nCards; i++) {
            int index = new Random().nextInt(cards.size());
            initCard card = cards.remove(index);
            ret.add(card);
            System.out.println("Card = " + card);
        }
        return ret;
    }
}
