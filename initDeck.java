import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;

import java.io.IOException;
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

                NodeList dictList = doc.getElementsByTagName("array");

                for (int i = 0; i<dictList.getLength(); i++) {

                    Node p = dictList.item(i);
                    if(p.getNodeType()==Node.ELEMENT_NODE){

                        Element key = (Element) p;
                        NodeList keyList = key.getChildNodes();

                        for(int j=0; j<keyList.getLength(); j++) {

                            Node q = keyList.item(j);

                            if (q.getNodeType()==Node.ELEMENT_NODE){

                                Element key2 = (Element) q;
                                NodeList key2List = key2.getChildNodes();


                                for (int k=0; k<key2List.getLength(); k++) {

                                    Node r = key2List.item(k);

                                    if (!(r.getNodeName().equals("#text"))) {

                                        switch(r.getTextContent()){
                                            case "fileName":
                                                r = key2List.item(k+2);
                                                fileNames.add(r.getTextContent());
                                                break;
                                            case "imageName":
                                                r = key2List.item(k+2);
                                                imageNames.add(r.getTextContent());
                                                break;
                                            case "card_type":
                                                r = key2List.item(k+2);
                                                card_types.add(r.getTextContent());
                                                break;
                                            case "title":
                                                r = key2List.item(k+2);
                                                titles.add(r.getTextContent());
                                                break;
                                            case "chemistry":
                                                r = key2List.item(k+2);
                                                chemistrys.add(r.getTextContent());
                                                break;
                                            case "classification":
                                                r = key2List.item(k+2);
                                                classifications.add(r.getTextContent());
                                                break;
                                            case "crystal_system":
                                                r = key2List.item(k+2);
                                                crystal_systems.add(r.getTextContent());
                                                break;
                                            case "occurrence":
                                                r = key2List.item(k+2);
                                                occurrences.add(r.getTextContent());
                                                //needs custom array formatting
                                                break;
                                            case "hardness":
                                                r = key2List.item(k+2);
                                                hardnesss.add(r.getTextContent());
                                                break;
                                            case "specific_gravity":
                                                r = key2List.item(k+2);
                                                specific_gravitys.add(r.getTextContent());
                                                break;
                                            case "cleavage":
                                                r = key2List.item(k+2);
                                                cleavages.add(r.getTextContent());
                                                break;
                                            case "crustal_abundance":
                                                r = key2List.item(k+2);
                                                crustal_abundances.add(r.getTextContent());
                                                break;
                                            case "economic_value":
                                                r = key2List.item(k+2);
                                                economic_values.add(r.getTextContent());
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
//                System.out.println(fileNames);
//                System.out.println(imageNames);
//                System.out.println(card_types);
//                System.out.println(titles);
//                System.out.println(chemistrys);
//                System.out.println(classifications);
//                System.out.println(crystal_systems);
//                System.out.println(occurrences);
//                System.out.println(hardnesss);
//                System.out.println(specific_gravitys);
//                System.out.println(cleavages);
//                System.out.println(crustal_abundances);
//                System.out.println(economic_values);
                for (int i = 0; i<fileNames.size(); i++){
                    
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
