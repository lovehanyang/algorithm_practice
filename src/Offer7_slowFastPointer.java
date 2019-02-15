public class Offer7_slowFastPointer {

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

        Node head = new Node();
        head.data = 1;
        head.next = new Node();
        head.next.data = 2;
        head.next.next = new Node();
        head.next.next.data = 3;

        System.out.println("中间元素为：" + getTheMid(head));
    }

    /**
     * 面试题：输入一个单链表的头结点，返回它的中间元素。为了方便，元素值用整型表示。
     */
    public static int getTheMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.data;
    }

    /**
     * 判断链表是否有环
     */
    private static boolean isRingLink(Node head) {
        Node slow = head;
        Node fast = head;

        while (slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast || fast.next == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * 输入一个单链表的头结点，输出该链表中倒数第 k 个节点的值
     */
    private static int getNodeIndex(Node head, int k) {
        Node slow = head;
        Node fast = head;

        if (slow == null)
            throw new RuntimeException();
        //让fast先走k-1步
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow.data;
    }

    /**
     * 面试题：定义一个单链表，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。为了方便，我们链表的 data 采用整型。
     */
    private static Node reverseLinklist(Node head) {
        Node pre = null;
        Node node = head;
        Node next = null;

        while (node != null) {
            next = node.next;
            head.next = pre;
            pre = head;
            node = next;
        }

        head = pre;
        return head;

    }

}
