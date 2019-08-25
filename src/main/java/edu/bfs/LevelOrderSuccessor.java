package edu.bfs;


import java.util.LinkedList;
import java.util.Queue;

class LevelOrderSuccessor {
    public static Node findSuccessor(Node root, int key) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
            if (node.val == key){
                break;
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        Node result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");

        //7, 10
    }
}