import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ethan on 15-Sep-16.
 */
public class initDeck {
    private static final int NUM_CARDS_INIT = 53; //this is the highest amount, add fail-safe later.  54 predefined cards, 53 + zero index
    private static ArrayList<String> fileNames = new ArrayList<>();
    private static ArrayList<String> imageNames = new ArrayList<>();
    private static ArrayList<String> card_types = new ArrayList<>();
    private static ArrayList<String> titles = new ArrayList<>();
    private static ArrayList<String> chemistrys = new ArrayList<>();
    private static ArrayList<String> classifications = new ArrayList<>();
    private static ArrayList<String> crystal_systems = new ArrayList<>();
    private static ArrayList<String> occurrences = new ArrayList<>();
    private static ArrayList<String> hardnesss = new ArrayList<>();
    private static ArrayList<String> specific_gravitys = new ArrayList<>();
    private static ArrayList<String> cleavages = new ArrayList<>();
    private static ArrayList<String> crustal_abundances = new ArrayList<>();
    private static ArrayList<String> economic_values = new ArrayList<>();

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

                traverse(doc.getDocumentElement());


//                for (int i = 0; i < NUM_CARDS_INIT; i++) {
////                    rawContent = doc.getElementsByTagName("dict").item(i).getTextContent();
////                    if (i == 0){
////                        //cut off unnecessary "cards" string before processing
////                        rawContent = rawContent.substring(5);
////                    }
////
////                    System.out.println("Card"+ i +" : " + rawContent);
////                    cards.add(new initCard(i));
//
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cards;
    }

    public static void traverse(Node node) {
        // do something with the current node instead of System.out
        System.out.println("New Node: " + node.getNodeName());
        System.out.println("New Node: " + node.getFirstChild());
        System.out.println("New Node: " + node.getFirstChild().getTextContent());
//        System.out.println("New Node: " + node.);
        //System.out.println("Node Value: " + node.getTextContent());
        //loop to find if node is called cards
            //for every dict in array
                //create array of arrays that store each cards info
        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);

            if (!(currentNode.getNodeName().equals("#text"))) {
                //do stuff
                switch(currentNode.getTextContent()){
                    case "fileName":
                        fileNames.add(currentNode.getTextContent());

                    case "imageName":
                    case "card_type":
                    case "title":
                    case "chemistry":
                    case "classification":
                    case "crystal_system":
                    case "occurrence":
                    case "hardness":
                    case "specific_gravity":
                    case "cleavage":
                    case "crustal_abundance":
                    case "economic_value":
                }

                System.out.println("value = '" + currentNode.getTextContent() + "'");
//                if (currentNode.getTextContent().equals("cards")) {
//                    System.out.println("Found Cards");
//                }
                //goto: next node
                traverse(currentNode);
            }
        }
//        NodeList nodeList = node.getChildNodes();
//        for (int i = 0; i < nodeList.getLength(); i++) {
//            Node currentNode = nodeList.item(i);
//            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
//                //calls this method for all the children which is Element
//                traverse(currentNode);
//            }
//        }
        //System.out.println(fileNames);
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
