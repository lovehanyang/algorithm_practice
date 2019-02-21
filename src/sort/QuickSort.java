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

        //取第一个元素作为基准元素
        int pivot = arr[startIndex];

        //大循环在左右指针重合或者相交时结束

        while (endIndex >= startIndex) {

            while (endIndex >= startIndex) {
                if (arr[endIndex] < pivot) {
                    arr[startIndex] = arr[endIndex];
                    //因为左边的值被替换，左边的已经满足要求了，所以左边需要++
                    startIndex++;
                    break;
                }
                endIndex--;
            }

            while (endIndex >= startIndex) {
                if (arr[startIndex] > pivot) {
                    arr[endIndex] = arr[startIndex];
                    //因为右边的值被替换，右边的已经满足要求了，所以右边需要--
                    endIndex--;
                    break;
                }
                startIndex++;
            }

        }
        arr[startIndex] = pivot;

        return pivot;
    }


}
