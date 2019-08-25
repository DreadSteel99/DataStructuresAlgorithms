package edu.bfs;

import java.util.*;

class ConnectAllSiblings {
    public static void connect(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode previousNode=null;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            if (previousNode!=null) {
                previousNode.next = node;
            }
            previousNode = node;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode current = root;
        System.out.println("Traversal using 'next' pointer: "); //12 7 1 9 10 5
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
