package by.training.delElems.controller;

import by.training.delElems.service.Service;
import by.training.delElems.view.View;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        View view = new View();
        Service service = new Service();

        ArrayList list = view.inputSequence();
        int[] array = new int [list.size()];

        for (int i = 0; i < array.length; ++i) {
            array[i++] = Integer.parseInt(list.get(i).toString());
        }

        service.delNumbers(array);
        view.viewArray(array);
    }
}
