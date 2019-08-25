package edu.bfs;

import java.util.*;

class RightViewTree {
    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode lastNode = null;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i =0;i<levelSize;i++){
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                lastNode=node;
            }

            if (lastNode!=null){
                result.add(lastNode);
            }

        }
        return result;
    }


    public static List<TreeNode> traverse1(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // if it is the last node of this level, add it to the result
                if (i == levelSize - 1)
                    result.add(currentNode);
                // insert the children of current node in the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.print(node.val + " ");
        }
    }
}
