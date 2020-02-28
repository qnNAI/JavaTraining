package by.training.part02.task02.controller.thread.countDown;

import by.training.part02.task02.beans.CountDownArray;

public class CountDownFinishThread extends Thread {
    private final int number;
    private CountDownArray array;

    public CountDownFinishThread(int number, CountDownArray array) {
        this.number = number;
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.getSize(); ++i) {
            if (array.getElem(i, i) == 0) {
                array.setElem(i, i, number);
            }
        }
    }
}
