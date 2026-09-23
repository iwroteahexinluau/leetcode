/* https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 * 111. Minimum Depth of Binary Tree
 *
 * Recursive Solution:
 * A leaf is a node with no children. We want to find the shortest path from the root to
 * the nearest leaf node. If we recursively call a null child, it returns 0, so we can't
 * use Math.min(leftDepth, rightDepth). If one child is null, we find the depth of the
 * other node.
 *
 * Time O(n), Space O(h)
 * h = height of the tree
 * Space is O(n) worst case.
 *
 * Iterative Solution:
 * We can use BFS with a queue to visit every node of the tree going level by level.
 * Every time we move to the next level, we increment our height counter. Once we find a
 * leaf node, we can immediately return the current height.
 *
 * Time O(n), Space O(n)
 * The queue holds the entire level of the tree at a time so O(n) space.
 */

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    // recursive solution
    public static int minDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth;
        // since root != null, we know that if left or right is null, then the other is not null
        if (root.left == null) {
            depth = minDepthRecursive(root.right) + 1;
        } else if (root.right == null) {
            depth = minDepthRecursive(root.left) + 1;
        } else {
            depth = Math.min(minDepthRecursive(root.left), minDepthRecursive(root.right)) + 1;
        }
        return depth;
    }

    // iterative solution
    public static int minDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null) {
                    return height + 1;
                } else if (current.right == null) {
                    queue.add(current.left);
                } else if (current.left == null) {
                    queue.add(current.right);
                } else {
                    queue.add(current.left);
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
        Integer[] b = {2, null, 3, null, 4, null, 5, null, 6};
        TreeNode b1 = TreeNode.buildHelper(b);

        System.out.println(minDepthRecursive(a1));
        System.out.println(minDepthRecursive(b1));
        System.out.println(minDepthIterative(a1));
        System.out.println(minDepthIterative(b1));
    }
}
