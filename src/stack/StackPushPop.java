package stack;

import java.util.Stack;

public class StackPushPop {

    public static void main(String[] arg) {

        int[] push = {1, 2, 3, 4, 5};
        int[] pop1 = {4, 5, 3, 2, 1};
        int[] pop2 = {4, 3, 5, 1, 2};

        System.out.println(isPushStack(push, pop1));
        System.out.println(isPushStack(push, pop2));

        int[] push6 = {1};
        int[] pop5 = {2};
        System.out.println(isPushStack(push6, pop5));

    }


    /**
     * 面试题：输入两个整数序列，第一个序列表示栈的压入顺序，请判断二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如：压入序列为{1，2，3，4，5}，那{4，5，3，2，1} 就是该栈的弹出顺序，
     * 而{4，3，5，1，2} 明显就不符合要求；
     */
    private static boolean isPushStack(int[] push, int[] pop) {
        if (push == null || pop == null || pop.length != push.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int hasPushed = 0;

        for (int i = 0; i < pop.length; i++) {
            //第一步判断站定元素是否和pop[i]相等
            if (!stack.isEmpty() && pop[i] == stack.peek()) {
                stack.pop();
            } else {
                if (hasPushed == push.length) {
                    return false;
                }
                while (hasPushed < push.length) {
                    stack.push(push[hasPushed]);
                    hasPushed++;
                    if (pop[i] == stack.peek()) {
                        stack.pop();
                        break;
                    } else if (hasPushed == push.length) {
                        return false;
                    }
                }

            }
        }
        return true;
    }


}
