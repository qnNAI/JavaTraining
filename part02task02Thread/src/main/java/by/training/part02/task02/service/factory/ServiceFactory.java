package by.training.part02.task02.service.factory;

import by.training.part02.task02.service.readData.ReadArray;
import by.training.part02.task02.service.readData.ReadArrayFile;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ReadArray readArray = new ReadArrayFile();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ReadArray getArrayReader() {
        return readArray;
    }
}
