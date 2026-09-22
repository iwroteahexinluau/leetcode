/* https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * 94. Binary Tree Inorder Traversal
 *
 * Inorder Traversal visits the left node, then the root node, then the right node.
 *
 * Recursive Solution:
 * We go down each left tree as far as possible until we reach a null tree (the base
 * case). After we reach a null tree we recurse back up, add the root value to the
 * ArrayList, and then check the right tree.
 * Time O(n), Space O(h)
 * h = height of the tree
 *
 * Iterative Solution:
 * A more difficult solution because recursion lets the language itself handle the stack.
 * We go as far down the left tree as possible adding each node to a stack so we can
 * backtrack after we reach a null node. After we reach a null node, we pop the stack and
 * move back to that node adding the root value to the List and then continue with the
 * right tree.
 * Time O(n), Space O(h)
 * h = height of the tree
 *
 * Worst case O(h) is O(n)
 */

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

class Solution {
    // recursive solution
    public static List<Integer> inorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            List<Integer> order = new ArrayList<>();
            return order;
        }

        List<Integer> order = inorderTraversalRecursive(root.left);
        order.add(root.val);
        order.addAll(inorderTraversalRecursive(root.right));

        return order;
    }
    // iterative solution
    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            order.add(current.val);
            current = current.right;
        }
        return order;
    }

    public static void main(String[] args) {
        Integer[] a = {1, null, 2, 3};
        TreeNode a1 = TreeNode.buildHelper(a);
        Integer[] b = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};
        TreeNode b1 = TreeNode.buildHelper(b);

        System.out.println(inorderTraversalRecursive(a1));
        System.out.println(inorderTraversalRecursive(b1));
        System.out.println(inorderTraversalIterative(a1));
        System.out.println(inorderTraversalIterative(b1));
    }
}
