package by.training.task01.dao.file;

import by.training.task01.dao.DataReader;
import by.training.task01.dao.daoException.DAOException;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements DataReader {
    public List<String> readData(String filename) throws DAOException {
        ArrayList<String> list = new ArrayList<>();
        String line = "";

        File file = new File(filename);

        try (java.io.FileReader fileReader = new java.io.FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {

            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception ex) {
            throw new DAOException("ошибка работы с файлом!", ex);
        }

        return list;
    }
}
