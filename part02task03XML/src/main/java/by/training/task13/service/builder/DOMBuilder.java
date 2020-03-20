package by.training.task13.service.builder;

import by.training.task13.beans.Product;
import by.training.task13.beans.Purchase;
import by.training.task13.beans.User;
import by.training.task13.service.serviceException.ServiceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;

public class DOMBuilder extends BaseBuilder {
    private DocumentBuilder documentBuilder;

    public DOMBuilder() {
        users = new HashSet<User>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildUsers(String sourceName) throws ServiceException  {
        Document document = null;

        try {
            document = documentBuilder.parse("D:\\Java\\JavaProjects\\JavaTraining\\part02task03XML\\src\\main\\resources\\xml\\Entity.xml");
            Element root = document.getDocumentElement();

            NodeList usersList = root.getElementsByTagName("user");

            for (int i = 0; i < usersList.getLength(); ++i) {
                Element userElement = (Element) usersList.item(i);
                users.add(buildUser(userElement));
            }

        } catch (SAXException | IOException e) {
            throw new ServiceException("DOM error build users", e);
        }
    }

    public User buildUser(Element userElement) {
        User user = new User();

        user.setId(Integer.parseInt(userElement.getAttribute("id")));
        user.setRole(Integer.parseInt(userElement.getAttribute("role")));
        user.setState(Integer.parseInt(userElement.getAttribute("state")));

        user.setUsername(getElementTextContent(userElement, "username"));
        user.setPassword(getElementTextContent(userElement, "password"));
        user.setName(getElementTextContent(userElement, "name"));
        user.setSurname(getElementTextContent(userElement, "surname"));
        user.setPatronymic(getElementTextContent(userElement, "patronymic"));
        user.setEmail(getElementTextContent(userElement, "email"));
        user.setPhone(getElementTextContent(userElement, "phone"));

        NodeList purchasesList = userElement.getElementsByTagName("purchase");

        for (int i = 0; i < purchasesList.getLength(); ++i) {
            Element purchaseElement = (Element) purchasesList.item(i);
            user.getPurchases().add(buildPurchase(purchaseElement));
        }

        return user;
    }

    private Purchase buildPurchase(Element purchaseElement) {
        Purchase purchase = new Purchase();

        purchase.setId(Integer.parseInt(purchaseElement.getAttribute("id")));
        String state = purchaseElement.getAttribute("state");
        String obtainingMethod = purchaseElement.getAttribute("obtainingMethod");

        if (state.equals("изготавливается")) {
            purchase.setState(Purchase.State.IN_PRODUCTION);
        } else if (state.equals("готов")) {
            purchase.setState(Purchase.State.MADE);
        }

        if (obtainingMethod.equals("доставка")) {
            purchase.setObtaining_method(Purchase.Obtaining_method.DELIVERY);
        } else if (obtainingMethod.equals("самовывоз")) {
            purchase.setObtaining_method(Purchase.Obtaining_method.PICKUP);
        }

        purchase.setAddress(getElementTextContent(purchaseElement, "address"));
        purchase.setFinalPrice(Double.parseDouble(getElementTextContent(purchaseElement, "finalprice")));
        purchase.setDate(getElementTextContent(purchaseElement, "date"));
        purchase.setAmount(Integer.parseInt(getElementTextContent(purchaseElement, "amount")));

        NodeList productsList = purchaseElement.getElementsByTagName("product");

        for (int i = 0; i < productsList.getLength(); ++i) {
            Element productElement = (Element) productsList.item(i);
            purchase.getProducts().add(buildProduct(productElement));
        }

        return purchase;
    }

    private Product buildProduct(Element productElement) {
        Product product = new Product();

        product.setId(Integer.parseInt(productElement.getAttribute("id")));

        product.setName(getElementTextContent(productElement, "name"));
        product.setPrice(Double.parseDouble(getElementTextContent(productElement, "price")));
        product.setDescription(getElementTextContent(productElement, "description"));
        product.setImage_path(getElementTextContent(productElement, "image_path"));

        return product;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
