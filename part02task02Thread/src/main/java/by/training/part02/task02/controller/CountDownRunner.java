package by.training.part02.task02.controller;

import by.training.part02.task02.beans.CountDownArray;
import by.training.part02.task02.controller.thread.countDown.CountDownFinishThread;
import by.training.part02.task02.controller.thread.countDown.CountDownThread;
import by.training.part02.task02.service.factory.ServiceFactory;
import by.training.part02.task02.service.serviceException.ServiceException;
import by.training.part02.task02.view.viewFactory.ViewFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownRunner {
    private static final Logger logger = LogManager.getLogger(CountDownRunner.class.getName());

    public static void main(String[] args) {
        ViewFactory viewFactory = ViewFactory.getInstance();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        CountDownArray array;
        CountDownLatch countDownLatch;
        int[] elemNumbers;

        try {
            array = new CountDownArray(serviceFactory.getArrayReader().readArray("d:\\text.txt"));
            countDownLatch = new CountDownLatch(array.getSize() / 2);

            for (int i = 0; i < array.getSize() / 2; ++i) {
                elemNumbers = new int[2];
                elemNumbers[0] = i;
                elemNumbers[1] = array.getSize() - i - 1;

                new CountDownThread(i + 1, elemNumbers, countDownLatch, array).start();
                countDownLatch.countDown();
            }

            timeUnit.sleep(100);

            new CountDownFinishThread(array.getSize() + 10, array);

            viewFactory.getPrintReader().printArray(array.copyArray());

        } catch (ServiceException | NullPointerException | InterruptedException ex) {
            logger.error(ex.getMessage());
        }
    }
}
