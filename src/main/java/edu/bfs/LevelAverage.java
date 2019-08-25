package edu.bfs;

import java.util.*;

class LevelAverage {
    public static List<Double> findLevelAverages(Node root) {
        List<Double> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                levelSum += node.val;

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }

            result.add(levelSum / levelSize);

        }


        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.left.right = new Node(2);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result); //[12.0, 4.0, 6.5]
    }
}