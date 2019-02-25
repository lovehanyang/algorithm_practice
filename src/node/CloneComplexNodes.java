package node;

public class CloneComplexNodes {


    public static class Node {

        int data;
        Node next;
        Node sibling;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }


    public static void main(String[] args) {

        Node head1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        head1.sibling = node4;
        node2.sibling = null;
        node3.sibling = node5;
        node4.sibling = node2;
        node5.sibling = head1;

        Node root = complexListNode(head1);

    }

    private static Node complexListNode(Node head) {
        if (head == null)
            return null;
        // 第一步，复制结点，并用 next 连接
        cloneNodes(head);
        // 第二步，把 sibling 也复制起来
        connectNodes(head);
        // 第三步，返回偶数结点，连接起来就是复制的链表
        return reconnectList(head);
    }

    private static void cloneNodes(Node head) {
        Node node = null;
        while (head != null) {
            node = new Node(head.data);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
    }

    private static void connectNodes(Node head) {
        while (head != null) {
            if (head.sibling != null){
                head.next.sibling = head.sibling.next;
            }

            head = head.next.next;
        }
    }

    private static Node reconnectList(Node head) {
        if (head == null)
            return null;

        // 用于存放复制链表的头结点
        Node cloneHead = head.next;
        // 用于记录当前处理的结点
        Node temp = cloneHead;

        head.next = cloneHead.next;
        head = head.next;
        while (head != null) {
            // temp 代表的是复制结点
            // 先进行赋值
            temp.next = head.next;
            // 赋值结束应该给 next 指向的结点赋值
            temp = temp.next;
            // head 的下一个结点应该指向被赋值的下一个结点
            head.next = temp.next;
            head = temp.next;
        }
        return cloneHead;
    }


}
