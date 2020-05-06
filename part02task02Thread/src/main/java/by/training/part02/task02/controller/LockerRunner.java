package by.training.part02.task02.controller;

import by.training.part02.task02.controller.thread.locker.LockerFinishThread;
import by.training.part02.task02.controller.thread.locker.LockerThread;
import by.training.part02.task02.beans.LockerArray;
import by.training.part02.task02.service.factory.ServiceFactory;
import by.training.part02.task02.service.serviceException.ServiceException;
import by.training.part02.task02.view.viewFactory.ViewFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class LockerRunner {
    private static final Logger logger = LogManager.getLogger(LockerRunner.class.getName());

    public static void main(String[] args) {
        ViewFactory viewFactory = ViewFactory.getInstance();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LockerArray lockerArray;
        int[] elemNumbers;

        try {
            lockerArray = new LockerArray(serviceFactory.getArrayReader().readArray("d:\\text.txt"));

            for (int i = 0; i < lockerArray.getSize() / 2; ++i) {
                elemNumbers = new int[2];
                elemNumbers[0] = i;
                elemNumbers[1] = lockerArray.getSize() - i - 1;

                new LockerThread(i + 1, elemNumbers, lockerArray).start();
            }

            timeUnit.sleep(100);

            new LockerFinishThread(lockerArray.getSize() + 10, lockerArray);

            viewFactory.getPrintReader().printArray(lockerArray.copyArray());

        } catch (ServiceException | NullPointerException | InterruptedException e) {
            logger.error(e.getMessage());
        }
    }
}
