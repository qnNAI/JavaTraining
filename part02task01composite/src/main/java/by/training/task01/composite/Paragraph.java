package by.training.task01.composite;

public class Paragraph extends Composite {
    @Override
    public StringBuilder collect() {
        StringBuilder content = new StringBuilder();

        for (int i = 0; i < getChildSize(); ++i) {
            content.append(getChild(i).collect());
            content.append(". ");
        }

        return content;
    }
}
