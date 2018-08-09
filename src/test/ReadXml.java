package test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.File;

public class ReadXml {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File(".\\src\\xml\\01xml.xml"));
        System.out.println(doc);

    }
}
