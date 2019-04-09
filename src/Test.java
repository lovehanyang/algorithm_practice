public class Test {


    public static void main(String[] args) {
        int a = 10;
        System.out.print("1.输出数值："+ a +"  "+ delete(a) + "  " + a);
        a--;
        System.out.print("2.输出数值："+ a +"  "+ delete(a) + "  " + a);


    }

    public static int delete(int a){
        return --a;
    }

    public static int binarySearch(int[] a, int key) {
        int low = 0, mid, high = a.length - 1;

        while (high > low) {
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

    public static int getTheMin(int nums[]) {
        int low = 0, mid, high = nums.length - 1;
        while (nums[low] > nums[high]) {
            if (high - low == 1) {
                return nums[high];
            }

            mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid;
            } else if (nums[mid] < nums[low]) {
                high = mid;
            }
        }

        return nums[0];
    }


}
