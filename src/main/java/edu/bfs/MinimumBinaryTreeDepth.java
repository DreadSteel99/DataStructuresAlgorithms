package edu.bfs;

import java.util.LinkedList;
import java.util.Queue;

class MinimumBinaryTreeDepth {
    public static int findDepth(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int minDepth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            minDepth++;

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();

                if (node.left == null && node.right == null) {
                    return minDepth;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new Node(9);
        root.right.left.left = new Node(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}