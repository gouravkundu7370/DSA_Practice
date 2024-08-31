import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {
    public static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

        TreeNode getNode() {
            return node;
        }

        int getLevel() {
            return level;
        }

    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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

    public static int widthOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().getLevel();
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) {
                int curr_id = q.peek().getLevel() - mmin;
                TreeNode node = q.peek().getNode();
                q.poll();
                if (i == 0) {
                    first = curr_id;
                }
                if (i == size - 1) {
                    last = curr_id;
                }
                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * curr_id + 1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, 2 * curr_id + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(widthOfBinaryTree(root));
    }
}
