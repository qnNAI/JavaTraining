package by.training.part02.task02.controller.thread.countDown;

import by.training.part02.task02.beans.CountDownArray;

import java.util.concurrent.CountDownLatch;

public class CountDownThread extends Thread {
    private CountDownLatch countDown;
    private CountDownArray array;
    private final int number;
    private int[] elemNumbers;

    public CountDownThread(int number, int[] elemNumbers, CountDownLatch countDown, CountDownArray array) {
        this.number = number;
        this.elemNumbers = elemNumbers;
        this.countDown = countDown;
        this.array = array;
    }

    @Override
    public void run() {
        try {
            countDown.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int elemNumber : elemNumbers) {
            array.setElem(elemNumber, elemNumber, number);
        }
    }
}
