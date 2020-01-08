package by.training.task09.ex2.controller;

import by.training.task09.ex2.car.Car;
import by.training.task09.ex2.view.PrintReader;
import by.training.task09.ex2.wheel.Wheel;

public class Runner {
    public static void main(String[] args) {
        PrintReader printReader = new PrintReader();
        String wheelType;

        switch (printReader.inputWheelType()) {
            case 1: wheelType = "зимнее"; break;
            case 2: wheelType = "летнее"; break;
            default: wheelType = "летнее";
        }
        Wheel wheel = new Wheel(wheelType);

        Car car = new Car(wheel, printReader.inputCarModel());
        int choice = -1;

        while (choice != 0) {
            choice = printReader.inputChoice();

            switch (choice) {
                case 1: car.move(); break;
                case 2: car.refuel(); break;
                case 3: Wheel newWheel = new Wheel(printReader.inputWheelType() == 1 ? "зимнее" : "летнее");
                car.changeWheel(newWheel); break;
                case 4: car.printInfo(); break;
            }
        }

    }

}
