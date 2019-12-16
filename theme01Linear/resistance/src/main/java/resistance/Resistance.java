package resistance;


import java.util.Scanner;

public class Resistance {
    double R1 = 0;
    double R2 = 0;
    double R3 = 0;

    public static void main(String[] args)
    {
        Resistance resistance = new Resistance();
        Scanner input = new Scanner(System.in);

        double R1 = 0;
        double R2 = 0;
        double R3 = 0;
        double result_resistance = 0;

        System.out.println("Введите R1");
        R1 = input.nextDouble();

        System.out.println("Введите R2");
        R2 = input.nextDouble();

        System.out.println("Введите R3");
        R3 = input.nextDouble();

        resistance.setResistance(R1, R2, R3);
        result_resistance = (double)Math.round(resistance.calculateConnectionResistance() * 10000d) / 10000d;
        System.out.println("Сопротивление соединения = " + result_resistance);
    }

    public void setResistance(double R1, double R2, double R3)
    {
        this.R1 = R1;
        this.R2 = R2;
        this.R3 = R3;
    }

    public double calculateConnectionResistance()
    {
        return 1/(1/R1 + 1/R2 + 1/R3);
    }
}
