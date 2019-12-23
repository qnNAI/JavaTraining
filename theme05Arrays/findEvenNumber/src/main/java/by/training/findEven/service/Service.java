package by.training.findEven.service;

import java.util.ArrayList;

public class Service {
    public ArrayList findEvenNumbers(ArrayList array) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < array.size(); ++i) {
            if (Double.parseDouble(array.get(i).toString()) % 2 == 0) {
                list.add(array.get(i));
            }
        }
        return list;
    }
}
