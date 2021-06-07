package kr.or.ddit.parse;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParsing {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse("WebContent/WEB-INF/application-context.xml");

		Element root = document.getDocumentElement();

		NodeList childeren = root.getChildNodes();
		for (int i = 0; i < childeren.getLength(); i++) {

			Node node = childeren.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element ele = (Element) node;
				String nodeName = ele.getNodeName();
				System.out.println("node name: " + nodeName);

				if (nodeName.equals("bean")) {
					System.out.println("id: " + ele.getAttribute("id"));
					System.out.println("class: " + ele.getAttribute("class"));
					System.out.println("");
					if (ele.getAttribute("id").equals("menuService")) {
						System.out.println(nodeName + "의 내부 속성");
						NodeList childeren2 = ele.getChildNodes();
						for (int a = 0; a < childeren2.getLength(); a++) {
							Node node2 = childeren2.item(a);
							if (node2.getNodeType() == Node.ELEMENT_NODE) {
								Element ele2 = (Element) node2;
								String nodeName2 = ele2.getNodeName();
								System.out.println("property name : " + ele2.getAttribute("name"));
								System.out.println("property ref-value : " + ele2.getAttribute("ref-value"));
							}
						}
					}
				}
			}
		}
	}
}