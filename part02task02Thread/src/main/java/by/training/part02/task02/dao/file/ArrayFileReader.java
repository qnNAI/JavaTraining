package by.training.part02.task02.dao.file;

import by.training.part02.task02.dao.ArrayReader;
import by.training.part02.task02.dao.daoException.DAOException;

import java.io.*;

public class ArrayFileReader implements ArrayReader {
    @Override
    public int[][] readArray(String path) throws DAOException {
        File file = new File(path);
        int[][] array = null;

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bf = new BufferedReader(fileReader)) {

            String line;
            String[] numbers;
            int size;
            int lineCount = 0;

            while ((line = bf.readLine()) != null) {
                numbers = line.split(" ");

                if (array == null) {
                    size = numbers.length;
                    array = new int[size][size];
                } else {
                    size = array.length;
                }

                for (int i = 0; i < size; ++i) {
                    array[lineCount][i] = Integer.parseInt(numbers[i]);
                }

                ++lineCount;
            }


        } catch (IOException ex) {
            throw new DAOException("Read array exception", ex);
        }
        return array;
    }
}
