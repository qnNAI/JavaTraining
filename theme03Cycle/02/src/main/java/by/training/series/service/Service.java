package by.training.series.service;


public class Service {
    public double getSumSeries(double e)
    {
        int i = 0;
        double sum = 0;
        double result = calculateMember(0);

        while (e <= Math.abs(result))
        {
            sum+= result;
            i++;
            result = calculateMember(i);
        }
        return sum;
    }

    public double calculateMember(int i)
    {
        return  1.0 / (3 * i - 2) / (3 * i + 1);
    }
}
