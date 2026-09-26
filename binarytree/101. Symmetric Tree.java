/* https://leetcode.com/problems/symmetric-tree/description/
 * 101. Symmetric Tree
 *
 * Recursive Solution:
 * We want to check if the left side of the tree is a mirror of the right side, so we use
 * a recursive helper that compares left with right and right with left.
 *
 * Time O(n), Space O(h)
 * h = height of the tree
 * Space is O(n) worst case
 */

class Solution {
    public static boolean symmetricTreeHelper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        } else {
            return symmetricTreeHelper(p.left, q.right) && symmetricTreeHelper(p.right, q.left);
        }
    }
    public static boolean symmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetricTreeHelper(root.left, root.right);
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 2, 3, 4, 4, 3};
        TreeNode a1 = TreeNode.buildHelper(a);
        Integer[] b = {1, 2, 2, null, 3, null, 3};
        TreeNode b1 = TreeNode.buildHelper(b);

        System.out.println(symmetricTree(a1));
        System.out.println(symmetricTree(b1));
    }
}
