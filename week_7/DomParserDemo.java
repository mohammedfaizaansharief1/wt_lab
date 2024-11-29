// Week 7: Create an XML document that contains 10 users information. Write a Java program, which takes User Id as input and returns the user details by taking the user information from the XML document using DOM Parser.


// package week_7;

import java.io.File;
import java.util.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParserDemo {
    public static void main(String[] args) {
        try {
            int temp;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter ID");
            String id = sc.next();
            File inputFile = new File("students.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("student");
            System.out.println("	");

            for (temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                // System.out.println("\nCurrent Element :" +nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    // System.out.println("Student roll no : " + eElement.getAttribute("rollno"));
                    String r = eElement.getAttribute("rollno");
                    if (r.equals(id)) {
                        System.out.println("Student roll no : " + r);
                        System.out.println(
                                "First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                        System.out.println(
                                "Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                        System.out.println(
                                "Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                        System.out
                                .println("Marks : " + eElement.getElementsByTagName("marks").item(0).getTextContent());
                        break;
                    }
                }
            }

            if (temp >= nList.getLength()) {
                System.out.println(" Steudent Not Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
