package by.training.part02.task02.view.console;

public class PrintReader implements ConsolePrintReader {
    @Override
    public void printArray(int[][] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array.length; ++j) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
