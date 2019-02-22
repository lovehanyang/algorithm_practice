package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        printOrder(root);
        System.out.println();
    }

    /**
     * 从上到下打印二叉树（剑指 Offer 26 题 Java 实现）
     * @param root
     */
    private static void printOrder(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //使用poll和offer存取元素，可以防止异常
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + ",");

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


}
