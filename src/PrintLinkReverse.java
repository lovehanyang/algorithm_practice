import java.util.ArrayList;
import java.util.Stack;

public class PrintLinkReverse {


    public static class Node {
        int data;
        Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //方法一：
        Node head = new Node();
        head.data = 1;
        head.next = new Node();
        head.next.data = 2;
        head.next.next = new Node();
        head.next.next.data = 3;

        printLinkReverseMethod1(head);
        printLinkReverseMethod2(head);
        printLinkReverseMethod3(head);

        //递归：翻转链表
//        printLinkedList(reverseLinkedListRecursive(head));
        //非递归：翻转链表
        printLinkedList(reverseLinkedList(head));

    }

    private static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null)
            return null;

        Node p1 = head;
        Node p2 = head.next;
        Node p3 = null;

        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        head.next = null;
        head = p1;

        return head;

    }

    /**
     * 递归本质上也是一个栈结构!!!
     */
    private static void printLinkReverseMethod3(Node head) {
        if (head != null) {
            printLinkReverseMethod3(head.next);
            System.out.println("方法三：" + head.data);
        }

    }

    private static void printLinkReverseMethod2(Node head) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        while (!stack.isEmpty()) {
            System.out.println("方法二:" + stack.pop().data);
        }

    }

    private static void printLinkReverseMethod1(Node head) {
        ArrayList<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println("方法一：" + list.get(i).data);
        }
    }


    public static Node reverseLinkedListRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //再将当前节点设置为后面节点的后续节点
        Node pNode = reverseLinkedListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return pNode;
    }


    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print("值：" + head.data);
            System.out.print(" ");
            head = head.next;
        }
        System.out.println();
    }


}
