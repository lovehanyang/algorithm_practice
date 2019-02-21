package node;

public class MergeNode {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node((7));

        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);

        Node head = mergeCycle(head1, head2);

        while (head != null) {
            System.out.print(head.data + "-->");
            head = head.next;
        }
    }

    public static Node mergeCycle(Node head1, Node head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        Node head = new Node(0);
        Node temp = head;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                head.next = head1;
                head1 = head1.next;
            } else {
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }

        //如果第一个链表没有处理完毕，将剩余元素放到链表后
        if (head1 != null) {
            head.next = head1;
        }

        //同理
        if (head2 != null) {
            head.next = head2;
        }

        return temp.next;
    }

    public static Node mergeRecursion(Node head1, Node head2) {
        // 如果链表 1 为 null ,新链表直接为 2 链表；
        if (head1 == null)
            return head2;
        // 如果链表 2 为 null,则新链表直接为 1 链表
        if (head2 == null)
            return head1;
        Node head;
        // 假设链表 1 的头结点值小于等于链表 2；则直接把链表 1 的头结点赋值为新链表，并递归新的 1 链表
        if (head1.data <= head2.data) {
            head = head1;
            head.next = mergeRecursion(head1.next, head2);
        } else {
            // 否则，对链表 2 执行同样的操作，并把脱离的值赋值上去
            head = head2;
            head.next = mergeRecursion(head1, head2.next);
        }
        return head;
    }
}
