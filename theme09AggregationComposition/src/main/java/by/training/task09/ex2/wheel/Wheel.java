package by.training.task09.ex2.wheel;

import by.training.task09.ex2.view.PrintReader;

public class Wheel {
    String type;
    boolean isRotating = false;

    public Wheel(String type) {
        this.type = type;
    }

    public Wheel() {
        type = "Летнее";
    }

    public void rotate() {
        PrintReader.printMessage("Колесо вращается.");
        isRotating = true;
    }

    public void stopRotate() {
        if (isRotating) {
            PrintReader.printMessage("Колесо остановило вращение.");
            isRotating = false;
        } else {
            PrintReader.printMessage("Колесо не вращается.");
        }
    }

    public String getType() {
        return type;
    }
}
