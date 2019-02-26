public class offer19_MoreThanHalf {


    private static int moreThanHalfNums(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new RuntimeException("the length of array must be large than 0");
        int result = nums[0];
        int times = 1;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (times == 0) {
                result = nums[i];
                times = 1;
            } else if (result == nums[i])
                times++;
            else
                times--;
        }
        return result;
    }

}
