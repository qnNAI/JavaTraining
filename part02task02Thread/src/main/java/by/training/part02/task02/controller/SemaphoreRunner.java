package by.training.part02.task02.controller;

import by.training.part02.task02.beans.SemaphoreArray;
import by.training.part02.task02.controller.thread.semaphore.SemaphoreFinishThread;
import by.training.part02.task02.controller.thread.semaphore.SemaphoreThread;
import by.training.part02.task02.service.factory.ServiceFactory;
import by.training.part02.task02.service.serviceException.ServiceException;
import by.training.part02.task02.view.viewFactory.ViewFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class SemaphoreRunner {
    private static final Logger logger = LogManager.getLogger(SemaphoreRunner.class.getName());

    public static void main(String[] args) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ViewFactory viewFactory = ViewFactory.getInstance();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SemaphoreArray semaphoreArray = null;

        try {
            semaphoreArray = new SemaphoreArray(serviceFactory.getArrayReader().readArray("d:\\text.txt"));

            for (int i = 0; i < semaphoreArray.getSize(); ++i) {
                new SemaphoreThread(i + 1, semaphoreArray).start();
            }

            timeUnit.sleep(100);

            new SemaphoreFinishThread(semaphoreArray.getSize() + 10, semaphoreArray).start();

            viewFactory.getPrintReader().printArray(semaphoreArray.copyArray());

        } catch (ServiceException | InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
