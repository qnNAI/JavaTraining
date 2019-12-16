package distance;

import java.util.Scanner;

public class DistanceCalculation {
    double speed_lake = 0;
    double speed_of_river = 0;
    double time_lake = 0;
    double time_river = 0;

    public static void main(String[] args)
    {
        DistanceCalculation distance_calculation =  new DistanceCalculation();
        Scanner input = new Scanner(System.in);

        double distance = 0;
        double speed_lake = 0;
        double speed_of_river = 0;
        double time_lake = 0;
        double time_river = 0;

        System.out.println("Введите скорость движения в стоячей воде");
        speed_lake = input.nextDouble();

        System.out.println("Введите скорость течения реки");
        speed_of_river = input.nextDouble();

        System.out.println("Введите время движения по озеру");
        time_lake = input.nextDouble();

        System.out.println("Введите время движения по реке");
        time_river = input.nextDouble();

        distance_calculation.setParams(speed_lake, time_lake, speed_of_river, time_river);
        distance = distance_calculation.getDistance();

        System.out.println("Пройденный путь = " + distance);

    }

    public void setParams(double speed_lake, double time_lake, double speed_of_river, double time_river)
    {
        this.speed_lake = speed_lake;
        this.speed_of_river = speed_of_river;
        this.time_lake = time_lake;
        this.time_river = time_river;
    }

    public double getDistance()
    {
        return (speed_lake * time_lake) + ((speed_lake - speed_of_river) * time_river);
    }
}
