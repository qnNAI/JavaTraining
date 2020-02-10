package by.training.task01.dao.factory;

import by.training.task01.dao.DataReader;
import by.training.task01.dao.DataWriter;
import by.training.task01.dao.file.FileReader;
import by.training.task01.dao.file.FileWriter;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final DataReader fileReader = new FileReader();
    private final DataWriter fileWriter = new FileWriter();

    private DAOFactory() {} ;

    public static DAOFactory getInstance() {
        return instance;
    }

    public DataReader getDataReader() {
        return fileReader;
    }

    public DataWriter getDataWriter() {
        return fileWriter;
    }
}
