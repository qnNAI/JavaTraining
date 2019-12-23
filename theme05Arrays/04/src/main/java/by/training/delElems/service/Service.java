package by.training.delElems.service;

public class Service {

    public void delNumbers(int[] array) {

       for (int i = 0; i < array.length; ++i) {
           if (array[i] % 2 == 0) {
               shiftElems(array, i, i, array.length - i);
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
}