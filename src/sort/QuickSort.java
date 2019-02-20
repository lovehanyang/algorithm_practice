package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] arg) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            System.out.println("startIndex:" + startIndex + ", endIndex:" + endIndex + "return!!!");
            return;
        }

        //得到基准元素的位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);

    }

    private static int partition(int[] arr, int startIndex, int endIndex) {


        return 0;
    }


}
