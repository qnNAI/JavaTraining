package by.training.theme10.exercise04.view;

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
        System.out.println("add_to_selected - добавить сокровище в список выбранных - команда прилагательное существительное стоимость");
        System.out.println("erase_selected - очистить список выбранных сокровищ - команда");
        System.out.println("find_max - найти самое дорогое сокровище - команда");
        System.out.println("generate - сгенерировать сокровища- команда");
        System.out.println("read_file - считать список сокровищ из файла - команда путь+имя_файла");
        System.out.println("set_av_price - задать доступную сумму - команда доступная_сумма");
        System.out.println("show - просмотреть список сокровищ - команда");
        System.out.println("take - забрать выбранные сокровища - команда");
        System.out.println("write_file - записать список сокровищ в файл - команда путь+имя_файла");
        System.out.println("exit - выход из программы - команда");
        System.out.println();

    }
}
