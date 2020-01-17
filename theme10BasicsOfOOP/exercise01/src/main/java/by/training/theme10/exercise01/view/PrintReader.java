package by.training.theme10.exercise01.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrintReader {
    public String scanRequest() {
        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextLine();
        } catch (InputMismatchException ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public void printResponse(String response) {
        System.out.println(response);
        System.out.println();
    }

    public void printMenu() {
        System.out.println("Введите запрос:");
        System.out.println("create - создать текстовый файл");
        System.out.println("rename - переименовать текстовый файл");
        System.out.println("add_info - добавить информацию в конец текстового файла");
        System.out.println("show_info - вывести данные из текстового файла");
        System.out.println("erase - стереть содержимое текстового файла");
        System.out.println("delete - удалить текстовый файл");
        System.out.println("exit - выход из программы");
        System.out.println();
        System.out.println("Команда вводится в формате: команда параметр1 параметр2 ...");
    }
}
