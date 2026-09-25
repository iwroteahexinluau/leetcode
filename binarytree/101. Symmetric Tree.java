/* https://leetcode.com/problems/symmetric-tree/description/
 * 101. Symmetric Tree
 *
 */

class Solution {
    public static boolean symmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        return root.left.equals(root.right);
    }

    public static void main(String[] args) {

    }
}
