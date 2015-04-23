package tsp.simulatie;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("serial")
public class XmlParser extends JFrame {

    private int afstand;
    private String soortAlgoritme;
    private int aantalPakketen;
    private int dimensies;
    private ArrayList<Record> records = new ArrayList<>();

    public XmlParser() {
        xmlFileUitlezen();
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    protected void xmlFileUitlezen() {
        final File xmlFile = new File("src//xml//LogboekXML.xml");
        if (xmlFile != null) {

            try {

                //setup
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(xmlFile);
                doc.getDocumentElement().normalize();

                //xml waarden in attributen stoppen
                NodeList RecordsList = doc.getElementsByTagName("Record");
                for (int temp = 0; temp < RecordsList.getLength(); temp++) {

                    Node node = RecordsList.item(temp);

                    if (node.getNodeType() == Node.ELEMENT_NODE) {

                        Element eElement = (Element) node;

                        String tempAfstand = eElement.getElementsByTagName("Afstand").item(0).getTextContent();
                        afstand = Integer.parseInt(tempAfstand);

                        soortAlgoritme = eElement.getElementsByTagName("Algoritme").item(0).getTextContent();

                        String tempaantalPakketen = eElement.getElementsByTagName("AantalPaketten").item(0).getTextContent();
                        aantalPakketen = Integer.parseInt(tempAfstand);

                        String tempdimensies = eElement.getElementsByTagName("Dimensie").item(0).getTextContent();
                        dimensies = Integer.parseInt(tempAfstand);

                        Record record = new Record(afstand, soortAlgoritme, aantalPakketen, dimensies);
                        records.add(record);
                    }
                }
                for(Record r : records)
                    {
                        System.out.println(r.toString());
                    }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
