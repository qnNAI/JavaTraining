package by.training.task01.dao.file;

import by.training.task01.dao.DataReader;
import by.training.task01.dao.daoException.DAOException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements DataReader {
    public String readData(String filename) throws DAOException {
        String data;

        try {
            data = new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException ex) {
            throw new DAOException("Read data -> IOException", ex);
        }

        return data;
    }
}
