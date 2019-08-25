package edu.dfs;

import java.util.*;


class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsRecursive(root, allPaths, currentPath, sum);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode node, List<List<Integer>> allPaths, List<Integer> currentPath, int sum) {
        if (node == null) return;

        currentPath.add(node.val);

        if (node.val == sum && node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            findPathsRecursive(node.left, allPaths, currentPath, sum - node.val);
            findPathsRecursive(node.right, allPaths, currentPath, sum - node.val);
        }

        //TODO: Backtracking removal trick
        currentPath.remove(currentPath.size() - 1);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
