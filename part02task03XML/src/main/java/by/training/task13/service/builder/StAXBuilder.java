package by.training.task13.service.builder;

import by.training.task13.beans.Product;
import by.training.task13.beans.Purchase;
import by.training.task13.beans.handlerEnum.Product_Enum;
import by.training.task13.beans.handlerEnum.Purchase_Enum;
import by.training.task13.beans.handlerEnum.User_Enum;
import by.training.task13.beans.User;
import by.training.task13.service.serviceException.ServiceException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

public class StAXBuilder extends BaseBuilder {
    private XMLInputFactory inputFactory;

    public StAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        users = new HashSet<User>();
    }

    @Override
    public void buildUsers(String sourceName) throws ServiceException {
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;
        int type = 0;

        try {
            inputStream = new FileInputStream(new File(sourceName));
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();

                    if (name.equals("user")) {
                        User user = buildUser(reader);
                        users.add(user);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            throw new ServiceException("StAX error build users", e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new ServiceException("StAX error close input stream", e);
                }
            }
        }
    }

    private User buildUser(XMLStreamReader reader) throws ServiceException {
        User user = new User();

        user.setId(Integer.parseInt(reader.getAttributeValue(0)));
        user.setRole(Integer.parseInt(reader.getAttributeValue(1)));
        user.setState(Integer.parseInt(reader.getAttributeValue(2)));

        String name;
        int type;

        try {
            while (reader.hasNext()) {
                type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();

                        if (name.equals("purchase")) {
                            user.getPurchases().add(buildPurchase(reader));
                        }
                        else {
                            switch (User_Enum.valueOf(name.toUpperCase())) {
                                case USERNAME:
                                    user.setUsername(readCharacters(reader));
                                    break;
                                case PASSWORD:
                                    user.setPassword(readCharacters(reader));
                                    break;
                                case NAME:
                                    user.setName(readCharacters(reader));
                                    break;
                                case SURNAME:
                                    user.setSurname(readCharacters(reader));
                                    break;
                                case PATRONYMIC:
                                    user.setPatronymic(readCharacters(reader));
                                    break;
                                case EMAIL:
                                    user.setEmail(readCharacters(reader));
                                    break;
                                case PHONE:
                                    user.setPhone(readCharacters(reader));
                                    break;
                            }
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (name.equals("user")) {
                            return user;
                        }
                        break;
                }
            }

        } catch (XMLStreamException e) {
            throw new ServiceException("StAX error build user", e);
        }
        return user;
    }

    private Purchase buildPurchase(XMLStreamReader reader) throws ServiceException {
        Purchase purchase = new Purchase();

        purchase.setId(Integer.parseInt(reader.getAttributeValue(0)));
        String state = reader.getAttributeValue(1);
        String obtainingMethod = reader.getAttributeValue(2);

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

        String name;
        int type;

        try {
            while (reader.hasNext()) {
                type = reader.next();

                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();

                        if (name.equals("product")) {
                            purchase.getProducts().add(buildProduct(reader));
                        }
                        else {
                            switch (Purchase_Enum.valueOf(name.toUpperCase())) {
                                case ADDRESS:
                                    purchase.setAddress(readCharacters(reader));
                                    break;
                                case FINALPRICE:
                                    purchase.setFinalPrice(Double.parseDouble(readCharacters(reader)));
                                    break;
                                case DATE:
                                    purchase.setDate(readCharacters(reader));
                                    break;
                                case AMOUNT:
                                    purchase.setAmount(Integer.parseInt(readCharacters(reader)));
                                    break;
                            }
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (name.equals("purchase")) {
                            return purchase;
                        }
                        break;
                }
            }

        } catch (XMLStreamException e) {
            throw new ServiceException("StAX error build purchase", e);
        }

        return purchase;
    }

    private Product buildProduct(XMLStreamReader reader) throws ServiceException {
        Product product = new Product();

        product.setId(Integer.parseInt(reader.getAttributeValue(0)));

        String name;
        int type;

        try {
            while (reader.hasNext()) {
                type = reader.next();

                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        name = reader.getLocalName();

                        switch (Product_Enum.valueOf(name.toUpperCase())) {
                            case NAME:
                                product.setName(readCharacters(reader));
                                break;
                            case PRICE:
                                product.setPrice(Double.parseDouble(readCharacters(reader)));
                                break;
                            case DESCRIPTION:
                                product.setDescription(readCharacters(reader));
                                break;
                            case IMAGE_PATH:
                                product.setImage_path(readCharacters(reader));
                                break;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        name = reader.getLocalName();
                        if (name.equals("product")) {
                            return product;
                        }
                }
            }

        } catch (XMLStreamException e) {
            throw new ServiceException("StAX error build product", e);
        }
        return product;
    }

    private String readCharacters(XMLStreamReader reader) throws ServiceException {
        StringBuilder result = new StringBuilder();
        try {
            while (reader.hasNext()) {
                int eventType = reader.next();
                switch (eventType) {
                    case XMLStreamReader.CHARACTERS:
                    case XMLStreamReader.CDATA:
                        result.append(reader.getText());
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        return result.toString();
                }
            }
        } catch (XMLStreamException e) {
            throw new ServiceException("StAX error read characters", e);
        }
        return result.toString();
    }
}
