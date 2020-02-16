package by.training.part02.task02.ex01_hello_world;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {
    static final Logger rootLogger = LogManager.getRootLogger();


    public static void main(String[] args) {
        rootLogger.info("main thread");

        MyThread myThread = new MyThread();
        myThread.start();



    }

}
