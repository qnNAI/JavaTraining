package by.training.part02.task02.controller.thread.semaphore;

import by.training.part02.task02.beans.SemaphoreArray;
import by.training.part02.task02.beans.beansException.BeansException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SemaphoreThread extends Thread {
    private static final Logger logger = LogManager.getLogger(SemaphoreThread.class.getName());
    private final int number;
    private SemaphoreArray semaphoreArray;

    public SemaphoreThread(int number, SemaphoreArray semaphoreArray) {
        this.number = number;
        this.semaphoreArray = semaphoreArray;
    }

    @Override
    public void run() {
        Random random = new Random();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;

        int size = semaphoreArray.getSize();
        int i;

        try {
            while (!semaphoreArray.isFilled()) {
                i = random.nextInt(size);

                if (semaphoreArray.getElem(i, i) == 0) {
                    semaphoreArray.setElem(number, i, i);
                }
                timeUnit.sleep(10);
            }
        } catch (BeansException | InterruptedException ex) {
            logger.error(ex.getMessage());
        }
    }
}
