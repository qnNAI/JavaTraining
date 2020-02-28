package by.training.part02.task02.controller.thread.semaphore;

import by.training.part02.task02.beans.SemaphoreArray;
import by.training.part02.task02.beans.beansException.BeansException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SemaphoreFinishThread extends Thread {
    private static final Logger logger = LogManager.getLogger(SemaphoreFinishThread.class.getName());
    private final int number;
    private SemaphoreArray semaphoreArray;

    public SemaphoreFinishThread(int number, SemaphoreArray semaphoreArray) {
        this.number = number;
        this.semaphoreArray = semaphoreArray;
    }

    @Override
    public void run() {
        try {
            if (!semaphoreArray.isFilled()) {
                for (int i = 0; i < semaphoreArray.getSize(); ++i) {
                    if (semaphoreArray.getElem(i, i) == 0) {
                        semaphoreArray.setElem(number, i, i);
                    }
                }
            }
        } catch (BeansException e) {
            logger.error(e.getMessage());
        }
    }
}
