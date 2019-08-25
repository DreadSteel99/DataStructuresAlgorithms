package edu.bfs;

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int x) {
        val = x;
    }
};

class LevelOrderTraversal {
    public static List<List<Integer>> traverse(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()){

            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>(levelSize);

            for (int i=0;i<levelSize; i++) {
                Node currNode = queue.poll();
                levelList.add(currNode.val);

                if (currNode.left != null) {
                    queue.offer(currNode.left);
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

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
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}