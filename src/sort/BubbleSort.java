package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int array[] = new int[]{5, 8, 6, 3, 9, 2, 1, 7};
        bubbleSort(array);
        System.out.println("排序后的数组" + Arrays.toString(array));

    }


    public static void bubbleSort(int[] array) {
        int temp;
        boolean isSort = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSort = false;
                }
            }

            if (isSort)
                break;

        }
    }
}
