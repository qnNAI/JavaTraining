package by.training.arrayofnumbers.service;

public class Service {
    public int getSumDigits(int number) {
        int sum = 0;
        while (number >= 10) {
            sum += number % 10;
            number /= 10;
        }
        sum += number;
        return sum;
    }
}
