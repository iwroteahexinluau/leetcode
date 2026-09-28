/* https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 * 144. Binary Tree Preorder Traversal
 *
 * Recursive Solution:
 * Add the root value then recurse to the left subtree then the right subtree. Using
 * addAll() is slightly extra overhead and the list could be passed in as a parameter.
 *
 * Time O(n), Space O(h)
 * h = height of the tree
 * Space is O(n) worst case
 *
 * Iterative Solution:
 * DFS with a stack, adding root value then pushing the right subtree onto the stack if
 * it exists, then pushing the left subtree onto the stack if it exists because a stack
 * is LIFO.
 *
 * Time O(n), Space O(h)
 * h = height of the tree
 * Space is O(n) worst case, 
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;

class Solution {
    public static List<Integer> preorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> results = new ArrayList<>();
        results.add(root.val);
        results.addAll(preorderTraversalRecursive(root.left));
        results.addAll(preorderTraversalRecursive(root.right));
        return results;
    }
    
    public static List<Integer> preorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            results.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Integer[] a = {1, null, 2, 3};
        TreeNode a1 = TreeNode.buildHelper(a);
        Integer[] b = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};
        TreeNode b1 = TreeNode.buildHelper(b);
        Integer[] c = {};
        TreeNode c1 = TreeNode.buildHelper(c);
        Integer[] d = {1};
        TreeNode d1 = TreeNode.buildHelper(d);

        System.out.println(preorderTraversalRecursive(a1));
        System.out.println(preorderTraversalRecursive(b1));
        System.out.println(preorderTraversalRecursive(c1));
        System.out.println(preorderTraversalRecursive(d1));
        System.out.println(preorderTraversalIterative(a1));
        System.out.println(preorderTraversalIterative(b1));
        System.out.println(preorderTraversalIterative(c1));
        System.out.println(preorderTraversalIterative(d1));
    }
}
