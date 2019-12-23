package by.training.viewNumbers.service;

import java.util.ArrayList;

public class Service {
    public ArrayList findNumbers(ArrayList array) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < array.size(); ++i) {
            if (Integer.parseInt(array.get(i).toString()) > i) {
                list.add(array.get(i));
            }
        }
        return list;
    }
}

