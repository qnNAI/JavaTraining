package by.training.task04.summary.service;


public class Service {
    public double getMin(double number1, double number2, double number3)
    {
        return Math.min(number1, Math.min(number2, number3));
    }

    public double getMax(double number1, double number2, double number3)
    {
        return Math.max(number1, Math.max(number2, number3));
    }

    public double sum(double number1, double number2)
    {
        return number1 + number2;
    }
}
