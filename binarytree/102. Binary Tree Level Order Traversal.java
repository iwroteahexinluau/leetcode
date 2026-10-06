/* https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * 102. Binary Tree Level Order Traversal
 *
 * We can use BFS with a queue to visit every level of the tree at a time. At each level
 * we add each node's value to the level's array list.
 *
 * Time O(n), Space O(w)
 * w = width of the tree
 * Space is O(n) worst case
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;

class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> entry = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                entry.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            results.add(entry);
        }
        return results;
    }

    public static void main(String[] args) {
        Integer[] a = {3, 9, 20, null, null, 15, 7};
        TreeNode a1 = TreeNode.buildHelper(a);
        Integer[] b = {1};
        TreeNode b1 = TreeNode.buildHelper(b);
        Integer[] c = {};
        TreeNode c1 = TreeNode.buildHelper(c);

        System.out.println(levelOrder(a1));
        System.out.println(levelOrder(b1));
        System.out.println(levelOrder(c1));
    }
}
