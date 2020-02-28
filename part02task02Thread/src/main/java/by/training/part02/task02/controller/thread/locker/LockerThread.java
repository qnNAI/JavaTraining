package by.training.part02.task02.controller.thread.locker;

import by.training.part02.task02.beans.LockerArray;

public class LockerThread extends Thread {
    private LockerArray array;
    private final int number;
    private int[] elemNumbers;

    public LockerThread(int number, int[] elemNumbers, LockerArray array) {
        this.number = number;
        this.elemNumbers = elemNumbers;
        this.array = array;
    }

    @Override
    public void run() {
        for (int elemNumber : elemNumbers) {
            array.setElem(elemNumber, elemNumber, number);
        }
    }
}
