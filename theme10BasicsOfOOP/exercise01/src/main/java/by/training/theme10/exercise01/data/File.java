package by.training.theme10.exercise01.data;

import java.io.IOException;

public abstract class File {
    private Directory dir;          // директория файла
    private java.io.File filename;  // имя файла

    // конструкторы с параметрами
    public File(String dir, String filename) {
        this.dir = new Directory(dir);
        this.filename = new java.io.File(filename);
    }

    public File(java.io.File dir, java.io.File filename) {
        this.dir = new Directory(dir);
        this.filename = filename;
    }

    public File(java.io.File dir, String filename) {
        this.dir = new Directory(dir);
        this.filename = new java.io.File(filename);
    }

    public File(String dir, java.io.File filename) {
        this.dir = new Directory(dir);
        this.filename = filename;
    }

    // конструктор без параметров
    public File() {
        dir = null;
        filename = null;
    }

    // геттеры
    public java.io.File getFilename() {
        return filename;
    }

    public java.io.File getDir() {
        return dir.getDir();
    }

    public java.io.File getFullPath() {
        return new java.io.File(dir.getDir(), filename.getName());
    }

    // сеттеры
    public void setPathFiles(java.io.File dir, java.io.File filename) {
        this.dir = new Directory(dir);
        this.filename = filename;
    }

    public void setPathStrings(String dir, String filename) {
        this.dir = new Directory(dir);
        this.filename = new java.io.File(filename);
    }

    public void setPathFileString(java.io.File dir, String filename) {
        this.dir = new Directory(dir);
        this.filename = new java.io.File(filename);
    }

    public void setPathStringFile(String dir, java.io.File filename) {
        this.dir = new Directory(dir);
        this.filename = filename;
    }

    // абстрактные методы - для каждого типа файла своя реализация
    //получить содержимое файла
    public abstract String getContent() throws IOException;

    // добавить информацию в файл
    public abstract void addInfo(String info) throws IOException;

    // внутренний класс Директория
    public class Directory {
        private java.io.File dir;

        public Directory(String dir_name) {
            dir = new java.io.File(dir_name);
        }

        public Directory(java.io.File dir) {
            this.dir = dir;
        }

        public Directory() {
            dir = null;
        }

        public java.io.File getDir() {
            return dir;
        }

        public void setDirString(String dir) {
            this.dir = new java.io.File(dir);
        }

        public void setDirFile(java.io.File dir) {
            this.dir = dir;
        }
    }

}
