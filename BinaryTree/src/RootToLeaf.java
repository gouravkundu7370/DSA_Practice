import java.util.*;
public  class RootToLeaf {
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
        System.out.println(Paths(root));
    }

    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        find(root, list,new ArrayList<>());
        return list;
    }

    public static void find(Node root, ArrayList<ArrayList<Integer>> list,ArrayList<Integer> path) {
        
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            list.add(path);
        }
        find(root.left, list, new ArrayList<>(path));
        find(root.right, list, new ArrayList<>(path));
    }
}
