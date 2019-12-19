package by.training.series.runner;

import by.training.series.service.Service;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        double e = 0;

        System.out.println("Введите число е");
        e = scanner.nextDouble();

        System.out.println("Сумма членов = " + service.getSumSeries(e));
    }
}
