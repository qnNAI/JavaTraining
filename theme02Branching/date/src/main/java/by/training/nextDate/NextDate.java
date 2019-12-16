package by.training.nextDate;

import java.util.Scanner;

public class NextDate {
    private int day = 0;
    private int month = 0;
    private int year = 0;

    public static void main(String[] args)
    {
        boolean isExit = false;
        Scanner input = new Scanner(System.in);
        String inputLine = "";

        NextDate nextDate = new NextDate();

        while (!isExit) {
            System.out.println("Введите команду: ");
            System.out.println("1 - продолжить работу");
            System.out.println("0 - выход");

            inputLine = input.nextLine();

            if (inputLine.equals("1"))
            {
                nextDate = new NextDate();
            } else if (inputLine.equals("0"))
            {
                isExit = true;
            } else System.out.println("Неверная команда!");
        }
    }

    public NextDate()
    {
        readDate();
        if (CheckDate.checkDate(day, month, year)) {
            printNextDate();
            setToNull();
        } else {
            System.out.println("Дата не валидна!");
            setToNull();
        }

    }

    public void readDate() {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите день");
        day = input.nextInt();

        System.out.println("Введите месяц");
        month = input.nextInt();

        System.out.println("Введите год");
        year = input.nextInt();

    }


    private void setToNull()
    {
        day = 0;
        month = 0;
        year = 0;
    }

    private void printNextDate()
    {
        if (CheckDate.nextDay(day, month, year))
        {
            System.out.println("Слеующая дата - " + (day + 1) + "." + month + "." + year);
        } else if (CheckDate.nextMonth(day, month, year))
        {
            System.out.println("Слеующая дата - " + "01." + (month + 1) + "." + year);
        } else {
            System.out.println("Слеующая дата - " + "01." + "01."  + (year + 1));
        }
    }

}
