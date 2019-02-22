package stack;

import java.util.Stack;

public class StackGetMain {

    public static void main(String[] args) {


    }

    /**
     * 题目：实现一个栈，带有出栈（pop），入栈（push），
     * 取最小元素（getMin）三个方法。要保证这三个方法的时间复杂度都是O（1）
     */

    public class MinStack {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minValueStack = new Stack<>();

        public void push(int x) {
            stack.push(x);
            if (minValueStack.isEmpty() || x < minValueStack.peek()) {
                minValueStack.push(x);
            }
        }

        public void pop() {
            int value = stack.pop();
            if (value == minValueStack.peek())
                minValueStack.pop();
        }

        public int peek() {
            return stack.peek();
        }

        public int getMin() {
            return minValueStack.peek();
        }

    }


}
