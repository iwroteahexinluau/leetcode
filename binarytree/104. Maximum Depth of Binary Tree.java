/* https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 * 104. Maximum Depth of Binary Tree
 *
 * Recursive Solution:
 * Our base case is when root == null and we return 0. Otherwise we recurse and take the
 * max of left and right, then add + 1 for the current level.
 *
 * Time O(n), Space O(n)
 *
 * Iterative Solution:
 * Use BFS with a queue to visit every node in the tree and determine the number of
 * levels the tree has (height). At every level, we iterate through the queue adding the
 * left and right children for the next level to the queue if possible. As we move to
 * each level, we increment height keeping track of our total number of levels.
 *
 * Time O(n), Space O(n)
 */

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    // recursive solution
    public static int maxDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right)) + 1;
        return depth;
    }

    // iterative solution
    public static int maxDepthIterative(TreeNode root) {
        int height = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            height++;
        }
        return height;
    }

    public static void main(String[] args) {
        Integer[] a = {3, 9, 20, null, null, 15, 7};
        TreeNode a1 = TreeNode.buildHelper(a);
        Integer[] b = {1, null, 2};
        TreeNode b1 = TreeNode.buildHelper(b);

        System.out.println(maxDepthRecursive(a1));
        System.out.println(maxDepthRecursive(b1));
        System.out.println(maxDepthIterative(a1));
        System.out.println(maxDepthIterative(b1));
    }
}
