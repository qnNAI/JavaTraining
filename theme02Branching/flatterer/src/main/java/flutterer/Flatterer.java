package flutterer;

public class Flatterer {
    public void printMessage(String str)
    {
        if (str.equals("М"))
        {
            System.out.println("Мне нравятся мальчики!");
        }
        else if (str.equals("Д"))
        {
            System.out.println("Мне нравятся девочки!");
        }
        else {
            System.out.println("Неверные данные!");
        }
    }
}
