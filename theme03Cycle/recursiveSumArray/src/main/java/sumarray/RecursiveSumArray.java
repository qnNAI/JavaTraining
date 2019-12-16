package sumarray;

public class RecursiveSumArray {

    public static void main(String[] args) {
        int sum = 0;
        int array[] = {1, 2, 3, 4, 5};

        for (int i = 0; i < array.length; i++)
        {
            sum += array[i];
        }
        System.out.println("Сумма = " + sum);

        RecursiveSumArray obj = new RecursiveSumArray();

        int i = 0;
        sum = 0;
        sum = obj.sumArray(array, i, sum);

        System.out.println("Сумма = " + sum);

    }

    public int sumArray(int array[], int i, int sum)
    {

        if (i < array.length)
        {
            sum += sumArray(array, i + 1, sum);
            sum += array[i];
        }



        return sum;
    }
}
