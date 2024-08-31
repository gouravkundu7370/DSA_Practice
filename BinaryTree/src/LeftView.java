import java.util.*;;
public class LeftView {
 public static   class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public static void main(String[] args) {
    Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);
        System.out.println(leftView(root));
       System.out.println(rightView(root));
}
      //Function to return list containing elements of left view of binary tree.
   public static ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        left(root, list,0);
        return list;
    }

    public static void left(LeftView.Node root, ArrayList<Integer> list, int level) {

        if (root == null) {
            return;
        }
        if (list.size() == level) {
            list.add(root.data);
        }
        left(root.left, list, level + 1);
        left(root.right, list, level + 1);
    }
  public static ArrayList<Integer> rightView(Node root)
    {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        right(root, list,0);
        return list;
    }

    public static void right(LeftView.Node root, ArrayList<Integer> list, int level) {

        if (root == null) {
            return;
        }
        if (list.size() == level) {
            list.add(root.data);
        }
        right(root.right, list, level + 1);
        right(root.left, list, level + 1);
    }

}
