package by.training.arrayofnumbers.view;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    public int getNumber(String message) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(message);
        return scanner.nextInt();
    }

    public void printArray(ArrayList list) {
        for (int i = 0; i < list.size(); ++i) {
            System.out.print(list.get(i) + " ");
        }
    }
}
