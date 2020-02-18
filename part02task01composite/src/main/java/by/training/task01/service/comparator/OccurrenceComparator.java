package by.training.task01.service.comparator;

import by.training.task01.composite.Component;
import by.training.task01.service.SymbolHandler;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OccurrenceComparator implements Comparator<Component> {

    @Override
    public int compare(Component o1, Component o2) {
        Pattern pattern = Pattern.compile(String.valueOf(SymbolHandler.symbol));

        String o1collect = o1.collect().toString();
        String o2collect = o2.collect().toString();
        Matcher matcher = pattern.matcher(o1collect);

        int count1 = 0;
        int count2 = 0;
        int result;

        while (matcher.find()) {
            ++count1;
        }

        matcher = pattern.matcher(o2collect);

        while (matcher.find()) {
            ++count2;
        }

        result = Integer.compare(count1, count2);

        if (result == 0) {  // возвращаем обратный результат для сортировки по убыванию
            return o1collect.compareTo(o2collect) * (-1);
        } else {
            return result * (-1);
        }
    }
}
