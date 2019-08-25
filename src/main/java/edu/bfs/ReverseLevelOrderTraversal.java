package edu.bfs;

import java.util.*;


class ReverseLevelOrderTraversal {
    public static List<List<Integer>> traverse(Node root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            ArrayList<Integer> levelList = new ArrayList<>(levelSize);

            for (int i=0;i<levelSize;i++){
                Node node = queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                levelList.add(node.val);
            }

            result.add(0, levelList);
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
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result); //[[9, 10, 5], [7, 1], [12]]
    }
}