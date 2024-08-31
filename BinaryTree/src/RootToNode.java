import java.util.*;

public class RootToNode {
    static class Node
    {
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }

}
    public static void main(String[] args) {
  Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        System.out.println(path(root, 7));
        System.out.println(path(root, 2));
        System.out.println(path(root, 9));
    }

    public static ArrayList<Integer> path(Node node, int B) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (node == null) {
            return arr;
        }
        getPath(node,arr, B);
    return arr;
    }

    private static boolean getPath(Node root, ArrayList<Integer> arr, int b) {
       
        if (root == null) {
            return false;
        }
        arr.add(root.data);
        if (root.data == b) {
            return true;
        }
        if (getPath(root.left, arr, b) || getPath(root.right, arr, b)) {
            return true;
        }
        arr.remove(arr.size() - 1);
        return false;
    }

    
}
