/* TreeNode
 *
 * My Binary Tree data structure that follows the documentation of the Leetcode TreeNode
 * class. The easiest way to create the TreeNode is by using the buildHelper method on
 * an Integer[] array exactly like how Leetcode displays the Binary Tree test cases.
 *
 */

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }
    
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    public static TreeNode buildHelper(Integer[] input) {
        if (input.length == 0 || input[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(input[0]);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int i = 1;

        while(!queue.isEmpty() && i < input.length) {
            TreeNode current = queue.poll();
            if (input[i] != null) {
                TreeNode left = new TreeNode(input[i]);
                current.left = left;
                queue.add(left);
            }
            i++;
            if (i < input.length && input[i] != null) {
                TreeNode right = new TreeNode(input[i]);
                current.right = right;
                queue.add(right);
            }
            i++;
        }
        return root;
    }

    public static TreeNode copyOf(TreeNode source) {
        if (source == null) {
            return null;
        }

        return new TreeNode(
                source.val,
                copyOf(source.left),
                copyOf(source.right)
                );
    }

    @Override
    public String toString() {
        StringBuilder printString = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            printString.append(current.val);

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            if (!queue.isEmpty()) {
                printString.append(", ");
            }
        }
        printString.append("]");
        return printString.toString();
    }
}
