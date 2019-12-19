package by.training.task4.service;

public class Service {
    public int calculateFactorial(int number)
    {
        int factorial = 1;
        for (int i = 1; i < number; i++)
        {
            factorial *= i;
        }
        return factorial;
    }

    public int sumFactorials(int number)
    {
        int sum = 0;
        for (int i = 1; i < number; i++)
        {
            if (i % 2 == 1) {
                sum += calculateFactorial(i);
            }
        }
        return sum;
    }
}
