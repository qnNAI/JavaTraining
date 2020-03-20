package by.training.task13.service.SAXUserHandler;

import by.training.task13.beans.handlerEnum.*;
import by.training.task13.beans.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class UserHandler extends DefaultHandler {
    private Set<User> users;

    private Purchase currentPurchase = null;
    private User currentUser = null;
    private Product currentProduct = null;

    private User_Enum userEnumCurrent = null;
    private Product_Enum productEnumCurrent = null;
    private Purchase_Enum purchaseEnumCurrent = null;

    public UserHandler() {
        users = new HashSet<User>();
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("purchase".equals(localName)) {
            currentPurchase = new Purchase();
            currentPurchase.setId(Integer.parseInt(attributes.getValue(0)));

            if (attributes.getValue(1).equals("изготавливается")) {
                currentPurchase.setState(Purchase.State.IN_PRODUCTION);
            } else if (attributes.getValue(1).equals("готов")) {
                currentPurchase.setState(Purchase.State.MADE);
            }

            if (attributes.getValue(2).equals("доставка")) {
                currentPurchase.setObtaining_method(Purchase.Obtaining_method.DELIVERY);
            } else if (attributes.getValue(2).equals("самовывоз")) {
                currentPurchase.setObtaining_method(Purchase.Obtaining_method.PICKUP);
            }

        } else if ("user".equals(localName)) {
            currentUser = new User();
            int id = Integer.parseInt(attributes.getValue(0));

            currentUser.setId(id);
            currentUser.setRole(Integer.parseInt(attributes.getValue(1)));
            currentUser.setState(Integer.parseInt(attributes.getValue(2)));

        } else if ("product".equals(localName)) {
            currentProduct = new Product();
            int id = Integer.parseInt(attributes.getValue(0));

            currentProduct.setId(id);

        } else if (currentProduct != null) {
            productEnumCurrent = Product_Enum.valueOf(localName.toUpperCase());
        } else if (currentPurchase != null) {
            purchaseEnumCurrent = Purchase_Enum.valueOf(localName.toUpperCase());
        } else if (currentUser != null) {
            userEnumCurrent = User_Enum.valueOf(localName.toUpperCase());
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("user".equals(localName)) {
            users.add(currentUser);
            currentUser = null;

        } else if("product".equals(localName)) {
            currentPurchase.getProducts().add(currentProduct);
            currentProduct = null;

        } else if ("purchase".equals(localName)) {
            currentUser.getPurchases().add(currentPurchase);
            currentPurchase = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length).trim();

        if (data.isEmpty()) {
            return;
        }

        if (currentProduct != null) {
            switch (productEnumCurrent) {
                case NAME:
                    currentProduct.setName(data);
                    break;

                case PRICE:
                    currentProduct.setPrice(Double.parseDouble(data));
                    break;

                case DESCRIPTION:
                    currentProduct.setDescription(data);
                    break;

                case IMAGE_PATH:
                    currentProduct.setImage_path(data);
                    break;
            }
        }

        else if (currentPurchase != null) {
            switch (purchaseEnumCurrent) {
                case ADDRESS:
                    currentPurchase.setAddress(data);
                    break;
                case FINALPRICE:
                    currentPurchase.setFinalPrice(Double.parseDouble(data));
                    break;
                case DATE:
                    currentPurchase.setDate(data);
                    break;
                case AMOUNT:
                    currentPurchase.setAmount(Integer.parseInt(data));
                    break;
            }
        }

        else if (currentUser != null) {
            switch (userEnumCurrent) {
                case USERNAME:
                    currentUser.setUsername(data);
                    break;

                case PASSWORD:
                    currentUser.setPassword(data);
                    break;

                case NAME:
                    currentUser.setName(data);
                    break;

                case SURNAME:
                    currentUser.setSurname(data);
                    break;

                case PATRONYMIC:
                    currentUser.setPatronymic(data);
                    break;

                case EMAIL:
                    currentUser.setEmail(data);
                    break;

                case PHONE:
                    currentUser.setPhone(data);
                    break;
            }
        }


    }
}
