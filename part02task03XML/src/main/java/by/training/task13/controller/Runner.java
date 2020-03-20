package by.training.task13.controller;

import by.training.task13.service.builder.*;
import by.training.task13.service.serviceException.ServiceException;

public class Runner {
    public static void main(String[] args) {
        String filename = "D:\\Java\\JavaProjects\\JavaTraining\\part02task03XML\\src\\main\\resources\\xml\\Entity.xml";
        String schema = "D:\\Java\\JavaProjects\\JavaTraining\\part02task03XML\\src\\main\\resources\\xml\\Entity.xsd";

        try {
            System.out.println(Director.createUsers("SAX", filename, schema));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
