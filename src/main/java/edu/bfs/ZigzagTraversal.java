package edu.bfs;

import java.util.*;

class ZigzagTraversal {
    public static List<List<Integer>> traverse(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight=true;
        while (!queue.isEmpty()){

            int levelSize = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>();

            for (int i=0;i<levelSize;i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (leftToRight) {
                    levelList.add(node.val);
                }
                else {
                    levelList.add(0,node.val);
                }

            }
            leftToRight=!leftToRight;
            result.add(levelList);

        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        root.right.left.left = new Node(20);
        root.right.left.right = new Node(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result); //[12], [1, 7], [9, 10, 5], [17, 20]]
    }
}