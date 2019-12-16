package compare;

import java.util.Scanner;

public class Compare {
    public static boolean compare(double S1, double S2)
    {
        return S1 > S2 ? true : false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double S1;
        double S2;

        System.out.println("Введите площадь 1 круга");
        S1 = input.nextDouble();

        System.out.println("Введите площадь 2 круга");
        S2 = input.nextDouble();

        if (Compare.compare(S1, S2))
        {
            System.out.println("Площадь 1 круга больше площади 2 круга");
        }
        else {
            System.out.println("Площадь 2 круга больше площади 1 круга");
        }
    }
}
