public class Offer6_sort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 7, 8, 5, 4, 15, 156};
        reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("调整顺序-->" + arr[i]);
        }
    }

    /**
     * 面试题：输入一个整型数组，实现一个函数来调整该数组中的数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分，希望时间复杂度尽量小。
     */
    private static int[] reOrderArray(int[] arr) {

        //奇数索引
        int oddIndex = 0;
        //偶数索引
        int evenIndex = arr.length - 1;

        while (oddIndex < evenIndex) {

            while (oddIndex < evenIndex && Math.abs(arr[oddIndex]) % 2 != 0) {
                oddIndex++;
            }

            while (oddIndex < evenIndex && Math.abs(arr[evenIndex]) % 2 != 1) {
                evenIndex--;
            }

            int temp = arr[oddIndex];
            arr[oddIndex] = arr[evenIndex];
            arr[evenIndex] = temp;
        }

        return arr;
    }

}
