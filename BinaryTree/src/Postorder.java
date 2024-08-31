import java.util.*;
public class Postorder {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        postorder(list, root);
        return list;
    }

    public static void postorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;

        }
        postorder(list, root.left);
        postorder(list, root.right);
        list.add(root.val);

    }
    public static void main(String[] args) {
           TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(6);
        System.out.println(postorderTraversal(node));
    }
}
