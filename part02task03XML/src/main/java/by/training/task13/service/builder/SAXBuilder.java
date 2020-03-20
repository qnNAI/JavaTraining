package by.training.task13.service.builder;

import by.training.task13.service.SAXUserHandler.UserHandler;
import by.training.task13.service.serviceException.ServiceException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

public class SAXBuilder extends BaseBuilder {
    private UserHandler userHandler = new UserHandler();
    private XMLReader reader;

    @Override
    public void buildUsers(String sourceName) throws ServiceException {
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(userHandler);
            reader.parse(sourceName);

            users = userHandler.getUsers();
            userHandler = null;
        } catch (SAXException | IOException e) {
            throw new ServiceException("SAX error build users", e);
        }

    }
}
