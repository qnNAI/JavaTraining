package by.training.findNumbersInRange.service;

import java.util.ArrayList;

public class Service {
    public ArrayList findNumbersInRange(ArrayList array, double[] range) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < array.size(); ++i) {
            double elem = Double.parseDouble(array.get(i).toString());
            if (elem >= range[0] && elem <= range[1]) {
                list.add(array.get(i));
            }
        }
        return list;
    }
}