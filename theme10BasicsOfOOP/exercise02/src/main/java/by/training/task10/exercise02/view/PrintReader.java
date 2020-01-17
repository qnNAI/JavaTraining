package by.training.task10.exercise02.view;

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
        System.out.println("add_prod_available - добавить товар в список доступных товаров - команда наименование цена количество ед. измерения");
        System.out.println("add_prod_payment - переименовать текстовый файл - команда наименование количество");
        System.out.println("cancel_payment - очистить корзину - команда");
        System.out.println("erase_prod - очистить список товаров - команда");
        System.out.println("make_payment - оформить покупку - команда");
        System.out.println("show_prod - просмотреть список доступных товаров - команда");
        System.out.println("remove_prod - удалить товар из списка доступных - команда наименование");
        System.out.println("exit - выход из программы - команда");
        System.out.println();
    }

}
