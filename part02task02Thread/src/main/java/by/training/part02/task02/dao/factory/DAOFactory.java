package by.training.part02.task02.dao.factory;


import by.training.part02.task02.dao.ArrayReader;
import by.training.part02.task02.dao.file.ArrayFileReader;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ArrayReader fileReader = new ArrayFileReader();

    private DAOFactory() {} ;

    public static DAOFactory getInstance() {
        return instance;
    }

    public ArrayReader getArrayReader() {
        return fileReader;
    }
}
