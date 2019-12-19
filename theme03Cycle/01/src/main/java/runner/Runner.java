package runner;

import service.Service;

public class Runner {
    public static void main(String[] args) {
        Service service = new Service();

        System.out.println("Произведение квадратов первых двухсот чисел = " + service.calculate().toString());
    }
}
