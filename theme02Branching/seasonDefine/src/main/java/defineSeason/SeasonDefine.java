package defineSeason;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

enum Month { DECEMBER, JANUARY, FEBRUARY,
            MARCH, APRIL, MAY,
            JUNE, JULY, AUGUST,
            SEPTEMBER, OCTOBER, NOVEMBER }

}

public class SeasonDefine {
    private final String WINTER = "winter";
    private final String AUTUMN = "autumn";
    private final String SPRING = "spring";
    private final String SUMMER = "summer";
    private final String ERROR = "error: month number";

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        SeasonDefine seasonDefine = new SeasonDefine();
        int month = 0;
        String result = "";

        try {
            System.out.println("Введите номер месяца");
            month = input.nextInt();


        result = seasonDefine.defineSeason(month);
        System.out.println(result);

        }catch (InputMismatchException ex)
        {
            System.out.println("error: not a month number");
            input.nextLine();
        }
    }

    public String defineSeason(int month)
    {
       // Month current;
        switch(month)
        {
            case Month.DECEMBER.ordinal():
            case 1:
            case 2: return WINTER;
            case 3:
            case 4:
            case 5: return SPRING;
            case 6:
            case 7:
            case 8: return SUMMER;
            case 9:
            case 10:
            case 11: return AUTUMN;
            default: return ERROR;
        }
    }

}
