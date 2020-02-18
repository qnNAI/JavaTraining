package by.training.task01.dao.file;

import by.training.task01.dao.DataWriter;
import by.training.task01.dao.daoException.DAOException;

import java.io.IOException;

public class FileWriter implements DataWriter {
    public void writeData(String data, String filename) throws DAOException {
        try (java.io.FileWriter writer = new java.io.FileWriter(filename)) {

            writer.write(data);

        } catch (IOException ex) {
            throw new DAOException("File write exception", ex);
        }
    }
}
