import java.util.ArrayList;
import java.util.Collection;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        Collection<String> result = new ArrayList<>();
        
        // Crée un parseur XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        // Parse le XML (en utilisant un InputSource serait mieux pour les gros fichiers)
        Document doc = builder.parse(new java.io.ByteArrayInputStream(xml.getBytes()));
        
        // Récupère tous les éléments <folder>
        NodeList nodeList = doc.getElementsByTagName("folder");
        
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getAttribute("name");
                
                // Vérifie si le nom commence par la lettre
                if (!name.isEmpty() && Character.toLowerCase(name.charAt(0)) == Character.toLowerCase(startingLetter)) {
                    result.add(name);
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"c\">" +
                    "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                    "</folder>" +
                    "<folder name=\"users\" />" +
                "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}
