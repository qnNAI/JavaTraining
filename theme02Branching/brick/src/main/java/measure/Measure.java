package measure;

public class Measure {
    public boolean isSuitable(double A, double B, double x, double y)
    {
        return A >= x && B >= y ? true : false;
    }
}
