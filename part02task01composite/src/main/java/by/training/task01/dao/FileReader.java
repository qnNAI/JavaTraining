package by.training.task01.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<String> parseFile(String filename) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        String line = "";

        File file = new File(filename);
        java.io.FileReader fileReader = new java.io.FileReader(file);

        try (BufferedReader reader = new BufferedReader(fileReader)) {
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException ex) {
            //throw new IOException("Не удалось считать данные из файла!", ex);
            // выбросить своё исключение
        }

        return list;
    }
}
