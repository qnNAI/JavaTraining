package by.training.part02.task02.ex01_hello_world;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread extends Thread {
    static final Logger tLogger = LogManager.getLogger(MyThread.class);

    public void run() {
        System.out.println("Hello World");

        tLogger.info("hello world thread");
    }


}
