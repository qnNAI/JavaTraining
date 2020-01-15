package by.training.theme10.exercise01.data;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFile extends File {

    // конструкторы с параметрами
    public TextFile(String dir, String filename) {
        super(dir, filename);
    }

    public TextFile(java.io.File dir, java.io.File filename) {
        super(dir, filename);
    }

    public TextFile(java.io.File dir, String filename) {
        super(dir, filename);
    }

    public TextFile(String dir, java.io.File filename) {
        super(dir, filename);
    }

    // конструктор без параметров
    public TextFile() {
        super();
    }

    // переопределяем абстрактные методы класса File
    // получить содержимое файла
    @Override
    public String getContent() throws IOException {
        return new String(Files.readAllBytes(Paths.get(getFullPath().getAbsolutePath())));
    }

    // добавить информацию в файл
    @Override
    public void addInfo(String info) throws IOException {
        try (FileWriter writer = new FileWriter(getFullPath().getAbsolutePath(), true)) {
            writer.write(info);
            writer.flush();
        } catch (IOException ex) {
            throw new IOException("Не удалось добавить информацию!", ex);
        }
    }



}
