package by.training.part02.task02.controller.thread.locker;

import by.training.part02.task02.beans.LockerArray;

public class LockerFinishThread extends Thread {
    private final int number;
    private LockerArray array;

    public LockerFinishThread(int number, LockerArray array) {
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
