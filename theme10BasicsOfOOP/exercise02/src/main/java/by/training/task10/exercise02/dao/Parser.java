package by.training.task10.exercise02.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<String> parseFile(String filename) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        String line = "";

        File file = new File(filename);
        FileReader fileReader = new FileReader(file);

        try (BufferedReader reader = new BufferedReader(fileReader)) {
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException ex) {
            throw new IOException("Не удалось считать данные из файла!", ex);
        }

        return list;
    }
}
