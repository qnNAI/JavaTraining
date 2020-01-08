package by.training.task09.ex2.car;

import by.training.task09.ex2.engine.Engine;
import by.training.task09.ex2.view.PrintReader;
import by.training.task09.ex2.wheel.Wheel;

public class Car {
    Engine engine;
    Wheel wheel;
    String model;

    public Car(Wheel wheel, String model) {
        String engineType;

        switch (PrintReader.inputEngineType()) {
            case 1: engineType = "бензиновый"; break;
            case 2: engineType = "дизельный"; break;
            case 3: engineType = "газовый"; break;
            default: engineType = "газовый";
        }

        engine = new Engine(engineType);

        this.wheel = wheel;
        this.model = model;
    }

    public Car() {
        engine = new Engine();
        wheel = new Wheel();
        model = "Ауди";
    }

    public void printInfo() {
        PrintReader.printMessage("Модель - " + model);
        PrintReader.printMessage("Двигатель - " + engine.getType());
        PrintReader.printMessage("Колесо - " + wheel.getType());
    }

    public void move() {
        engine.work();
        wheel.rotate();
        PrintReader.printMessage("Автомобиль едет.");
    }

    public void refuel() {
        engine.stopWork();
        wheel.stopRotate();
        PrintReader.printMessage("Автомобиль остановился для заправки.");
    }

    public void changeWheel(Wheel wheel) {
        PrintReader.printMessage("Колесо меняется с типа " + this.wheel.getType() + "на тип " + wheel.getType());
        this.wheel = wheel;
    }
}
