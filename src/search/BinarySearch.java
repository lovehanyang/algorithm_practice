package search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] array = {1, 3, 4, 5, 6, 7, 8, 9};

        System.out.print("5的索引为：" + binarySearch(array, 5));

        // 有重复数字，并且重复的数字刚好的最小的数字
        int[] array2 = {3, 4, 5, 6, 1, 2};
        System.out.println("最小的数字：" + getTheMin(array2));

    }


    /**
     * 二分查找概念
     */
    public static int binarySearch(int[] a, int key) {
        int low = 0, mid, high = a.length - 1;

        while (high >= low) {
            mid = (high + low) / 2;
            if (key > a[mid]) {
                low = mid + 1;
            } else if (key < a[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 题目：把一个数组最开始的若干个元素搬到数组的末尾，
     * 我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组 {3，4，5，1，2} 为数组 {1，2，3，4，5} 的一个旋转，该数组的最小值为 1。
     */
    public static int getTheMin(int nums[]) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (nums[low] >= nums[high]) {
            if (high - low == 1) {
                return nums[high];
            }

            mid = (low + high) / 2;

            if (nums[mid] < nums[low]) {
                high = mid;
            } else {
                low = mid;
            }

        }
        return nums[0];
    }


}
