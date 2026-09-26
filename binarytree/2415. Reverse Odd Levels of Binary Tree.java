/* https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
 * 2415. Reverse Odd Levels of Binary Tree
 *
 * Recursive Solution:
 * We can use a recursive helper that takes two mirrored nodes and a boolean that tracks
 * whether we are on an odd level. If we are on an odd level, we swap the values of the
 * two mirrored nodes. We then recursively compare the next mirrored pairs, left.left
 * with right.right and left.right with right.left
 *
 * A B C D -> A <-> D and B <-> C
 *
 * Time O(n), Space O(log n)
 * Space is O(log n) because the tree is guaranteed to be perfect (all parent nodes have
 * two children and all leaves are on the same level), so its height is log n.
 */


class Solution {
    public static void reverseOddLevelsHelper(TreeNode left, TreeNode right, boolean oddLevel) {
        if (left == null || right == null) {
            return;
        }

        if (oddLevel) {
            int newLeftVal = right.val;
            int newRightVal = left.val;
            left.val = newLeftVal;
            right.val = newRightVal;
        }
        reverseOddLevelsHelper(left.left, right.right, !oddLevel);
        reverseOddLevelsHelper(left.right, right.left, !oddLevel);
    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        reverseOddLevelsHelper(root.left, root.right, true);
        return root;
    }
    public static void main(String[] args) {
        Integer[] a = {2, 3, 5, 8, 13, 21, 34};
        TreeNode a1 = TreeNode.buildHelper(a);
        Integer[] b = {7, 13, 11};
        TreeNode b1 = TreeNode.buildHelper(b);
        Integer[] c = {0, 1, 2, 0, 0, 0, 0, 1, 1, 1, 1, 2 ,2, 2, 2};
        TreeNode c1 = TreeNode.buildHelper(c);

        System.out.println(reverseOddLevels(a1));
        System.out.println(reverseOddLevels(b1));
        System.out.println(reverseOddLevels(c1));
    }
}
