package view;

import account.BankAccount;
import client.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintReader {
    public int inputChoice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите вариант:");
        System.out.println("1 - добивать клиента");
        System.out.println("2 - добавить счёт");
        System.out.println("3 - заблокировать счёт");
        System.out.println("4 - разблокировать счёт");
        System.out.println("5 - пополнить счёт");
        System.out.println("6 - снять со счёта");
        System.out.println("7 - поиск счёта");
        System.out.println("8 - сортировка счетов");
        System.out.println("9 - сумма по счетам");
        System.out.println("10 - сумма по положительным счетам");
        System.out.println("11 - сумма по отрицательным счетам");
        System.out.println("12 - просмотр информации по счетам");
        System.out.println("0 - выход");
        System.out.println();

        return scanner.nextInt();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printAccList(ArrayList<BankAccount> list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i).getNumber());
        }
    }

    public void printClientList(ArrayList<Client> list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i).getID());
        }
    }

    public int scanSingleChoice() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    public double scanValueDouble() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextDouble();
    }

    public void showAccountsInfo(ArrayList<BankAccount> list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.println("Номер счёта: " + list.get(i).getNumber());
            System.out.println("Баланс = " + list.get(i).getValue());
            System.out.println("Статус - " + (list.get(i).isBlocked() ? "заблокирован" : "разблокирован"));
        }
    }

}
