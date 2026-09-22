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

class TreeNode {
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
        TreeNode a3 = new TreeNode(3);
        TreeNode a2 = new TreeNode(2, a3, null);
        TreeNode a1 = new TreeNode(1, null, a2);

        TreeNode b4 = new TreeNode(4);
        TreeNode b6 = new TreeNode(6);
        TreeNode b7 = new TreeNode(7);
        TreeNode b9 = new TreeNode(9);
        TreeNode b5 = new TreeNode(5, b6, b7);
        TreeNode b2 = new TreeNode(2, b4, b5);
        TreeNode b8 = new TreeNode(8, b9, null);
        TreeNode b3 = new TreeNode(3, null, b8);
        TreeNode b1 = new TreeNode(1, b2, b3);

        System.out.println(inorderTraversalRecursive(a1));
        System.out.println(inorderTraversalRecursive(b1));
        System.out.println(inorderTraversalIterative(a1));
        System.out.println(inorderTraversalIterative(b1));
    }
}
