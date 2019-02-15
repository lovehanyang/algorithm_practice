public class Fibonacci {

    public static void main(String[] args) {

//        System.out.println("方法一输出-->" + fn(10) + "  方法二输出-->" + superFn(10));
        System.out.println("方法二输出-->" + superFn(100));

    }


    private static int fn(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fn(n - 1) + fn(n - 2);

    }

    private static long superFn(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        long pre = 1, prePre = 0, result = 0;

        for (int i = 2; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

    public static int compute(int stair) {
        if (stair <= 0)
            return 0;
        if (stair == 1)
            return 1;

        return compute(stair - 1) + (stair - 2);

    }

}
