package by.training.amountofsubstructs.service;

public class Service {
    public int getSubstructedNumber(int number)
    {
        int sum = 0;
        int number_save = number;

        while(number >= 10)
        {
            sum += number % 10;
            number /= 10;
        }
        sum += number;

        return number_save - sum;
    }
}
