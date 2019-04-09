package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] arg) {
        int[] arr = new int[]{4,20 ,11,17,7, 6, 5, 3, 2, 8, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速从一组无序数中找到第k大的数（或前k个大的数）
     */
    public void findK(int k, int[] arr, int low, int high) {
        int temp = partition(arr, low, high);
        if (temp == k - 1) {
            System.out.print("第" + k + "大的数是：" + arr[temp]);
        } else if (temp > k - 1) {
            findK(k, arr, low, temp - 1);
        } else {
            findK(k, arr, temp + 1, high);
        }
    }


    private static void quickSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            System.out.println("startIndex:" + startIndex + ", endIndex:" + endIndex + "return!!!");
            return;
        }

        //得到基准元素的位置
        System.out.print("执行分区操作startIndex-->"+startIndex + "   endIndex-->" + endIndex + "\n");
        int pivotIndex = partition(arr, startIndex, endIndex);
        System.out.print("执行第1个quickSort，拿到的pivotIndex " + pivotIndex + "  startIndex-->" + startIndex + "\n");
        quickSort(arr, startIndex, pivotIndex - 1);
        System.out.print("执行第2个quickSort \n");
        quickSort(arr, pivotIndex + 1, endIndex);

    }

    private static int partition(int[] arr, int startIndex, int endIndex) {

        //取第一个元素作为基准元素
        int pivot = arr[startIndex];

        //大循环在左右指针重合或者相交时结束，需要三个while循环！！！
        while (endIndex > startIndex) {

            while (endIndex > startIndex) {
                //先从右边开始比
                if (pivot > arr[endIndex]) {
                    arr[startIndex] = arr[endIndex];
                    //因为左边的值被替换，左边的已经满足要求了，所以左边需要++
                    startIndex++;
                    break;
                }
                //否则证明右面已经满足要求了，右边需要--
                endIndex--;
            }

            while (endIndex > startIndex) {
                if (pivot < arr[startIndex]) {
                    arr[endIndex] = arr[startIndex];
                    endIndex--;
                    break;
                }
                startIndex++;
            }
        }
        arr[startIndex] = pivot;
        return startIndex;


//        // 取第一个位置的元素作为基准元素
//        int pivot = arr[startIndex];
//        int left = startIndex;
//        int right = endIndex;
//        // 坑的位置，初始等于pivot的位置
//        int index = startIndex;
//        //大循环在左右指针重合或者交错时结束
//        while (right >= left) {
//            //right指针从右向左进行比较
//            while (right >= left) {
//                if (arr[right] < pivot) {
//                    arr[left] = arr[right];
//                    index = right;
//                    left++;
//                    break;
//                }
//                right--;
//            }
//            //left指针从左向右进行比较
//            while (right >= left) {
//                if (arr[left] > pivot) {
//                    arr[right] = arr[left];
//                    index = left;
//                    right--;
//                    break;
//                }
//                left++;
//            }
//        }
//
//        System.out.print("返回值index-->" + index + "\n");
//        System.out.print("startIndex-->" + startIndex + "endIndex" + endIndex +  "\n");
//        arr[index] = pivot;
//        return index;
    }


}



