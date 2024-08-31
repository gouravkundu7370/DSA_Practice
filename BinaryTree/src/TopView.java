import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static class Pair {

        Node node;
        int val;

        Pair(Node node, int val) {
            this.node = node;
            this.val = val;
        }

        Node getKey() {
            return node;
        }

        int getValue() {
            return val;
        }

    }

    public static ArrayList<Integer> topView(Node root) {
        // add your code
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            Node n = p.getKey();
            int line = p.getValue();

            if (!mp.containsKey(line)) {
                mp.put(line, n.data);
            }
            if (n.left != null) {
                queue.add(new Pair(n.left, line - 1));
            }
            if (n.right != null) {
                queue.add(new Pair(n.right, line + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            list.add(entry.getValue());
        }

        return list;
    }
    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(11);
        root.right.left = new Node(9);
        root.right.right.left = new Node(10);
        System.out.println(topView(root));
    }
    
}
