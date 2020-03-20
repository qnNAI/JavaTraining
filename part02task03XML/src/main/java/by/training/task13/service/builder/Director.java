package by.training.task13.service.builder;

import by.training.task13.beans.User;
import by.training.task13.service.serviceException.ServiceException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Director {
    public static List<User> createUsers(String builderName, String sourceName, String schemaPath) throws ServiceException {
        BaseBuilder builder = null;

        if (!checkXmlforXsd(sourceName, schemaPath)) {
            return null;
        }

        if (builderName.equals("SAX")) {
            builder = new SAXBuilder();

        } else if (builderName.equals("DOM")) {
            builder = new DOMBuilder();

        } else if (builderName.equals("StAX")) {
            builder = new StAXBuilder();
        }

        if (builder != null) {
            builder.buildUsers(sourceName);
            return new ArrayList<>(builder.getUsers());
        }

        return new ArrayList<>();
    }

    private static boolean checkXmlforXsd(String xmlPath, String xsdPath) throws ServiceException {
        File xml = new File(xmlPath);
        File xsd = new File(xsdPath);

        if (!xml.exists() || !xsd.exists()) {
            return false;
        }

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsdPath));

            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlPath));

            return true;
        } catch (SAXException | IOException e) {
            throw new ServiceException("error validate xml for xsd", e);
        }

    }
}
