package by.training.theme10.exercise01.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrintReader {
    public String inputStringParameter(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);

        try {
            return scanner.nextLine();
        } catch(InputMismatchException ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public void printMenu() {
        System.out.println("Выберите действие: ");
        System.out.println("1 - Создать текстовый файл");
        System.out.println("2 - Переименовать текстовый файл");
        System.out.println("3 - Добавить информацию в конец текстового файла");
        System.out.println("4 - Вывести данные из текстового файла");
        System.out.println("5 - Стереть содержимое текстового файла");
        System.out.println("6 - Удалить текстовый файл");
        System.out.println("0 - Выход из программы");
    }

    public int scanChoice() {
        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public String scanDir() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите директорию");

        try {
            return scanner.nextLine();
        } catch (InputMismatchException ex) {
            return "";
        }
    }

    public String scanFilename() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя файла");

        try {
            return scanner.nextLine();
        } catch (InputMismatchException ex) {
            return "";
        }
    }

    public String scanParam(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);

        try {
            return scanner.nextLine();
        } catch (InputMismatchException ex) {
            return "";
        }
    }

    public void printResponse(String response) {
        System.out.println(response);
    }
}
