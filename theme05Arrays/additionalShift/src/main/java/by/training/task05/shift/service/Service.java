package by.training.task05.shift.service;

public class Service {
    public void shiftElems(int[] array, int pos1, int pos2, int amount)
    {
        for (int i = pos2; i >= pos1; --i) {
            int temp_index = i;
            for (int j = 0; j < amount; ++j) {
                swapElem(array, temp_index, temp_index + 1);
                ++temp_index;
            }
       }
    }

    public void swapElem(int[] array, int pos1, int pos2)
    {
        if (array.length > pos1 && array.length > pos2)
        {
            int temp = array[pos1];
            array[pos1] = array[pos2];
            array[pos2] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        Service service = new Service();
        service.shiftElems(array, 1,3, 2);

        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}
