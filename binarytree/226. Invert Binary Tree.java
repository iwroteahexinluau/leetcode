/* https://leetcode.com/problems/invert-binary-tree/description/
 * 226. Invert Binary Tree
 *
 * Recursive Solution:
 * We can recursively travel through the tree swapping root.left with root.right.
 *
 * Time O(n), Space O(h)
 * h = height of the tree
 * Space is O(n) worst case.
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // recursive solution
    public static TreeNode invertBinaryTreeRecursive(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode newRight = invertBinaryTreeRecursive(root.left);
        TreeNode newLeft = invertBinaryTreeRecursive(root.right);
        root.left = newLeft;
        root.right = newRight;
        return root;
    }

    // iterative solution
    public static TreeNode invertBinaryTreeIterative(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            TreeNode newLeft = current.right;
            TreeNode newRight = current.left;
            current.left = newLeft;
            current.right = newRight;

            if (current.right != null) {
                queue.add(current.right);
            }
            if (current.left != null) {
                queue.add(current.left);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] a = {4, 2, 7, 1, 3, 6, 9};
        TreeNode a1 = TreeNode.buildHelper(a);
        Integer[] b = {2, 1, 3};
        TreeNode b1 = TreeNode.buildHelper(b);
        Integer[] c = {};
        TreeNode c1 = TreeNode.buildHelper(c);
        TreeNode a2 = TreeNode.copyOf(a1);
        TreeNode b2 = TreeNode.copyOf(b1);
        TreeNode c2 = TreeNode.copyOf(c1);

        System.out.println(invertBinaryTreeRecursive(a1));
        System.out.println(invertBinaryTreeRecursive(b1));
        System.out.println(invertBinaryTreeRecursive(c1));
        System.out.println(invertBinaryTreeIterative(a2));
        System.out.println(invertBinaryTreeIterative(b2));
        System.out.println(invertBinaryTreeIterative(c2));
    }
}
