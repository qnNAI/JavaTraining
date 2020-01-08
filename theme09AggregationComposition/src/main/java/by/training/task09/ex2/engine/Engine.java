package by.training.task09.ex2.engine;

import by.training.task09.ex2.view.PrintReader;

public class Engine {
    String type;
    boolean isWorking = false;

    public Engine(String type) {
        this.type = type;
    }

    public Engine() {
        type = "Бензиновый";
    }

    public void work() {
        PrintReader.printMessage("Двигатель работает.");
        isWorking = true;
    }

    public void stopWork() {
        if (isWorking) {
            PrintReader.printMessage("Двигатель перестал работать.");
            isWorking = false;
        } else {
            PrintReader.printMessage("Двигатель не работает");
        }
    }

    public String getType() {
        return type;
    }
}
