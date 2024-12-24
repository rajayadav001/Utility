package rajviryadav.com.library;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlToJson
{
    public static String parseByDOM(String response,String ElementsByTagName1,String ElementsByTagName2) throws ParserConfigurationException, SAXException, IOException
    {
        //	Person person=new Person();
        String jsonData = "";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new InputSource(new StringReader(response)));
        // normalize the document
        doc.getDocumentElement().normalize();
        // get the root node
        NodeList nodeList = doc.getElementsByTagName(ElementsByTagName1);
        if (nodeList.getLength()!=0)
        {
            Element e = (Element) nodeList.item(0);
            NodeList n = e.getElementsByTagName(ElementsByTagName2);

            jsonData = getElementValue(n.item(0));
        }

        return jsonData;
    }
    public static final String getElementValue(Node elem) {
        Node child;
        if( elem != null)
        {
            if (elem.hasChildNodes())
            {
                for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() )
                {
                    if( child.getNodeType() == Node.TEXT_NODE  )
                    {
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }
}
