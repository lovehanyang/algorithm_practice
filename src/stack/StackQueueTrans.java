package stack;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTrans {


    public static void main(String arg[]) {

        Stack2Queue stack2Queue = new Stack2Queue();
        stack2Queue.enQueue(1);
        stack2Queue.enQueue(2);
        System.out.println(stack2Queue.deQueue());
        stack2Queue.enQueue(3);
        System.out.println(stack2Queue.deQueue());
        System.out.println(stack2Queue.deQueue());
    }

    public static class Queue2Stack {
        Queue<Integer> queueA = new ArrayDeque<>();
        Queue<Integer> queueB = new ArrayDeque<>();

        //入栈
        public void push(int node) {
            queueA.add(node);
        }

        //出栈
        public int pop() {
            if (queueA.isEmpty()) {
                while (!queueB.isEmpty()) {
                    queueA.add(queueB.poll());
                }
            }

            if (queueA.size() != 1) {
                while (queueA.size() != 1) {
                    queueB.add(queueA.poll());
                }
            }

            return queueA.poll();


        }


    }

    public static class Stack2Queue {

        private Stack<Integer> stackA = new Stack<>();
        private Stack<Integer> stackB = new Stack<>();

        /**
         * 入队操作
         */
        public void enQueue(int element) {
            stackA.push(element);
        }

        /**
         * 出队操作
         */
        public Integer deQueue() {
            if (stackB.isEmpty()) {
                if (stackA.isEmpty())
                    return null;

                while (!stackA.isEmpty()) {
                    stackB.push(stackA.pop());
                }

            }
            return stackB.pop();
        }
    }


}
