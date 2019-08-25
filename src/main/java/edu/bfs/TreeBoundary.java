package edu.bfs;

import java.util.*;

class TreeBoundary {
    public static List<TreeNode> findBoundary(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if(node.left==null && node.right==null){
                    result.add(node);
                }
                else if (i == 0) {
                    result.add(node);
                }
                else if (i == levelSize - 1) {
                    result.add(node);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(15);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        List<TreeNode> result = TreeBoundary.findBoundary(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " "); //12 7 1 4 10 5 9 15 6
        }
    }
}