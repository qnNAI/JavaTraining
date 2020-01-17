package by.training.task10.exercise02.dao;

import by.training.task10.exercise02.entity.Payment;
import by.training.task10.exercise02.service.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    public void writeProductsListToFile(String filename, List<Payment.Product> products, Service service) throws IOException {
        File file = new File(filename);

        try (FileWriter writer = new FileWriter(file, false)) { // try с параметрами для закрытия потока

            for (int i = 0; i < products.size(); ++i) {                 // записывам параметры товара в файл
                writer.write(service.makeStringParamsRow(products.get(i)));
            }

            writer.flush();

        } catch (IOException ex) {
            throw new IOException("Не удалось добавить информацию!", ex); // если возникла ошибка записи
        }
    }
}
