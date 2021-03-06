package by.training.task01.composite;

public class Sentence extends Composite {
    @Override
    public StringBuilder collect() {
        StringBuilder content = new StringBuilder();

        for (int i = 0; i < getChildSize(); ++i) {
            content.append(getChild(i).collect());
            content.append(' ');
        }

        if (content.charAt(content.length() - 1) == ' ') {
            content.deleteCharAt(content.length() - 1);
        }

        return content;
    }
}
