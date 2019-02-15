public class pow {

    public static void main(String arg[]) {

        System.out.println("计算结果-->"+ pow(2, 2));
    }


    /**
     * 面试题：尝试实现 Java 的 Math.pow(double base,int exponent) 函数算法，
     * 计算 base 的 exponent 次方，不得使用库函数，同时不需要考虑大数问题。
     */
    private static double pow(double base, int exponent) {
        // 因为除了 0 以外，任何数值的 0 次方都为 1，所以我们默认为 1.0；
        // 0 的 0 次方，在数学书是没有意义的，为了贴切，我们也默认为 1.0
        double result = 1.0;
        // 处理底数为 0 的情况，底数为 0 其他任意次方结果都应该是 0
        if (base == 0)
            return 0.0;
        // 处理负数次方情况
        boolean isNegetive = false;
        if (exponent < 0) {
            isNegetive = true;
            exponent = -exponent;
        }
        result = getTheResult(base, exponent);
        if (isNegetive)
            return 1 / result;
        return result;
    }

    private static double getTheResult(double base, int exponent) {
        // 如果指数为0，返回1
        if (exponent == 0) {
            return 1;
        }

        double result = getTheResult(base, exponent >> 1);

        result *= result;
        // 求最终值，如果是奇数，还要乘一次底数
        if ((exponent & 0x1) == 1) {
            result *= base;
        }

        return result;
    }


}
