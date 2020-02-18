package by.training.task01.service.comparator;

import by.training.task01.composite.Component;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSizeComparator implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
        Pattern pattern = Pattern.compile("\\W");
        Matcher matcher;

        int size1 = 0;
        int size2 = 0;

        for (int i = 0; i < o1.getChildSize(); ++i) { // word and mark
            matcher = pattern.matcher(o1.getChild(i).collect());
            if (!matcher.find()) {
                size1 += o1.getChild(i).getChildSize();
            }
        }

        for (int i = 0; i < o2.getChildSize(); ++i) { // word and mark
            matcher = pattern.matcher(o2.getChild(i).collect());
            if (!matcher.find()) {
                size2 += o2.getChild(i).getChildSize();
            }
        }


        return Integer.compare(size1, size2);
    }
}
