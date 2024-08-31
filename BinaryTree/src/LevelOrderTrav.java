import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTrav {
  

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

    public static List<List<Integer>> levelOrder(TreeNode root) {
         // Check if the root is null
        if (root == null) {
            return new ArrayList<>();  // Return an empty list if the tree is empty
        }

        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<List<Integer>> traversal = new ArrayList<>();

        queue.add(root);  // Add the root node to the queue

        // Start level-order traversal
        while (!queue.isEmpty()) {
            List<Integer> currLevel = new ArrayList<>();
            int currSize = queue.size();  // Get the number of nodes at the current level

            // Process all nodes at the current level
            for (int i = 0; i < currSize; i++) {
                TreeNode currNode = queue.poll();  // Get the next node

                // Add its value to the current level's list
                currLevel.add(currNode.val);

                // Add the children to the queue if they are not null
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }

            // Add the current level's list to the result
            traversal.add(currLevel);
        }

        return traversal;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(levelOrder(root));
        System.out.println(levelOrder1(root));
    }
   static  List<List<Integer>> levels = new ArrayList<>();

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) 
            return levels;

        helper(root, 0);

        return levels;
    }

    private static void helper(TreeNode node, int level) {
        if (levels.size() == level) 
            levels.add(new ArrayList<>());
        
        levels.get(level).add(node.val);

        if (node.left != null) 
            helper(node.left, level + 1);

        if (node.right != null) 
            helper(node.right, level + 1);
    }
}
