package by.training.task01.view;

import java.util.Scanner;

public class PrintReader {
    public String scanRequest() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void printResponse(String response) {
        System.out.println(response);
        System.out.println();
    }

    public void printMenu() {
        System.out.println("Введите запрос:");
        System.out.println("read_decompose - считать данные из файла. Параметр: имя файла");
        System.out.println("compose_write - составить текст и записать в файл. Параметр: имя файла");
        System.out.println("show - составить текст и вывести на консоль");
        System.out.println("sort_paragraphs - отсортировать абзацы");
        System.out.println("sort_sentences - отсортировать предложения");
        System.out.println("sort_lexemes - отсортировать слова по количеству вхождений символа. Параметр: символ");
        System.out.println("exit - выход из программы - команда");
        System.out.println();
    }
}
