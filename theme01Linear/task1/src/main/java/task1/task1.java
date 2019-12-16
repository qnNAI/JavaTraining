package task1;

import java.util.Scanner;


public class task1 {
     public static void main(String args[])
     {
         Scanner input = new Scanner(System.in);
         double x = 0;
         double y = 0;
         System.out.println("Введите х");
         x = input.nextDouble();

         System.out.println("Введите y");
         y = input.nextDouble();

         double result = (Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y)) * Math.tan(x * y);

         System.out.println("Результат: " + result);
     }
}
