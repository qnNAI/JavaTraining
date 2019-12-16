package by.training.nextDate;

public class CheckDate {
    public static boolean checkDate(int day, int month, int year) {
        if (day > 31 || day < 1) {
            return false;
        }

        if (month > 12 || month < 1) {
            return false;
        }

        if (year < 1) {
            return false;
        }

        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11: {
                if (checkDayAmount(day, 30))
                {
                    return true;
                } else return false;

            }

            case 2: {
                if (isYearLeap(year)) {
                    if (checkDayAmount(day, 29)) {
                        return true;
                    } else
                        return false;
                } else {
                    if (checkDayAmount(day, 28)) {
                        return true;
                    } else return false;
                }
            }
        }
        return true;
    }


    public static boolean isYearLeap(int year)
    {
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
        {
            return true;
        }
        return false;
    }

    private static boolean checkDayAmount(int day, int amount)
    {
        if (day > amount) {
           return false;
        } else
        return true;

    }

    public static boolean nextMonth(int day, int month, int year)
    {
        if (CheckDate.checkDate(1, month + 1, year))
        {
            return true;
        } else return false;
    }

    public static boolean nextDay(int day, int month, int year)
    {
        if (CheckDate.checkDate(day + 1, month, year))
        {
            return true;
        } else return false;
    }
}
