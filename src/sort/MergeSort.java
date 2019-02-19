package sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        mergeSort(arr, 0, 7);
        printArr(arr);
    }

    private static void printArr(int[] arr) {

        System.out.println("排序后的数组-->");

        for (int anArr : arr) {
            System.out.println(anArr + "");
        }
    }


    private static void mergeSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            System.out.println("start == end 被return");
            return;
        }

        //找出中间索引
        int mid = (startIndex + endIndex) / 2;
        System.out.println("mergeSort(startIndex:" + startIndex + ", mid:" + mid + ")");
        mergeSort(arr, startIndex, mid);
        System.out.println("mergeSort(mid + 1:" + (mid + 1) + ", endIndex:" + endIndex + ")");
        mergeSort(arr, mid + 1, endIndex);
        System.out.println("开始合并--> " + "startIndex:" + startIndex + "endIndex:" + endIndex);
        merge(arr, startIndex, mid, endIndex);
    }

    private static void merge(int[] arr, int startIndex, int mid, int endIndex) {

        //1.先建立一个临时数组，用于存放排序后的数据,创建临时数组下标pos
        int[] tempArray = new int[arr.length];
        int pos = startIndex;
        int start1 = startIndex, start2 = mid + 1;

        //2.开始比较
        while (start1 <= mid && start2 <= endIndex) {
            if (arr[start1] <= arr[start2]) {
                tempArray[pos++] = arr[start1++];
            } else {
                tempArray[pos++] = arr[start2++];
            }
        }

        //3.剩余部分依次放入临时数组,以下两个循环只会执行一个
        while (start1 <= mid) {
            tempArray[pos++] = arr[start1++];
        }

        while (start2 <= endIndex) {
            tempArray[pos++] = arr[start2++];
        }

        //4.将临时数组拷贝回原来的数组
        while (startIndex <= endIndex) {
            arr[startIndex] = tempArray[startIndex++];
        }
    }
}
