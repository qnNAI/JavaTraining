package by.training.theme10.exercise01.validation;

import java.io.File;

public class Validator {
    public boolean checkDir(String dir) {
        return new File(dir).isDirectory();
    }

    public boolean checkFile(String dir, String filename) {
        return new File(dir + filename).isFile();
    }

    public boolean checkFileFormat(String filename) {
        if (filename.length() < 5) {
            return false;
        }

        String txt_str = filename.substring(filename.length() -  4, filename.length());

        if (!txt_str.equals(".txt")) {
            return false;
        }

        if (!checkForbiddenSymbols(filename)) {
            return false;
        }

        return true;
    }

    public boolean checkForbiddenSymbols(String str) {
        char[] forbiddenSymbols = { '\\', ':', '*', '?', '\"', '<', '>', '|', '+', '-', '=', ',', '!',
                '@', '%', '&', '$', '^', '#', '(', ')', '`', '{', '}', '[', ']' };

        for (int i = 0; i < forbiddenSymbols.length; ++i) {
            if (str.indexOf(forbiddenSymbols[i]) != -1) {
                return false;
            }
        }
        return true;
    }
}
