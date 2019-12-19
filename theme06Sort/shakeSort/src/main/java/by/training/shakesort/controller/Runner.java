package by.training.shakesort.controller;

import by.training.shakesort.service.Service;

public class Runner {
    public static void main(String[] args) {
        Service service = new Service();

        service.shakeSort();
    }
}
