import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;



public class BottomView {
    public static class Pair {
    
        Node node;
        int val;

       public Pair(Node node, int val) {
            this.node = node;
            this.val = val;
        }
         public Node getKey() {
            return node;
        }

        public int getValue() {
            return val;
        }
    }
    public static class Node {
        int data;
        Node left;
        Node right;

        // Constructor to initialize
        // the node with a value
        public Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }
 public static ArrayList <Integer> bottomView(Node root)
 {
     ArrayList<Integer> ans = new ArrayList<>();

     // Check if the tree is empty
     if (root == null) {
         return ans;
     }

     // Map to store the bottom view nodes
     // based on their vertical positions
     Map<Integer, Integer> mpp = new TreeMap<>();

     // Queue for BFS traversal, each
     // element is a pair containing node
     // and its vertical position
     Queue<Pair> q = new LinkedList<>();

     // Push the root node with its vertical
     // position (0) into the queue
     q.add(new Pair(root, 0));

     // BFS traversal
     while (!q.isEmpty()) {
         // Retrieve the node and its vertical
         // position from the front of the queue
         Pair pair = q.poll();
         Node node = pair.getKey();
         int line = pair.getValue();

         // Update the map with the node's data
         // for the current vertical position
         mpp.put(line, node.data);

         // Process left child
         if (node.left != null) {
             // Push the left child with a decreased
             // vertical position into the queue
             q.add(new Pair(node.left, line - 1));
         }

         // Process right child
         if (node.right != null) {
             // Push the right child with an increased
             // vertical position into the queue
             q.add(new Pair(node.right, line + 1));
         }
     }

     // Transfer values from the
     // map to the result list
     for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
         ans.add(entry.getValue());
     }

     return ans;
 }
    public static void main(String[] args) {
         // Creating a sample binary tree
         Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(11);
        root.right.left = new Node(9);
        root.right.right.left = new Node(10);
        System.out.println(bottomView(root));
    }
}
