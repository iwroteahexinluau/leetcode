/* https://leetcode.com/problems/same-tree/description/
 * 100. Same Tree
 *
 * Recursive Solution:
 * We can recursively travel through every node in both trees comparing p.val with q.val.
 * If both trees equal null, then we have reached the base case and return true. If one
 * of the trees equals null while the other does not, we can immediately end the
 * recursion and return false.
 *
 * Time O(n), Space O(h)
 * h = height of the tree being traversed
 * Space is O(n) worst case.
 *
 * Iterative Solution:
 * We can use BFS using a linked list as a queue to visit each node in both trees. We 
 * store the  nodes we want to compare as an array inside the linked list, and check 
 * every pair. If the two nodes ever do not equal each other, then we immediately return
 * false. If we successfully iterate through the entire tree, we return true.
 *
 * Time O(n), Space O(n)
 * The queue holds the entire level of the tree at a time so O(n) space.
 */

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // recursive solution
    public static boolean sameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && sameTreeRecursive(p.left, q.left) && sameTreeRecursive(p.right, q.right);
    }

    // iterative solution
    public static boolean sameTreeIterative(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null || p.val != q.val) {
            return false;
        }

        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[] {p, q});

        while (!queue.isEmpty()) {
            TreeNode[] pair = queue.poll();
            TreeNode currentP = pair[0];
            TreeNode currentQ = pair[1];

            if (currentP == null && currentQ == null) {
                continue;
            } else if (currentP == null || currentQ == null || currentP.val != currentQ.val) {
                return false;
            }
            queue.add(new TreeNode[] {currentP.left, currentQ.left});
            queue.add(new TreeNode[] {currentP.right, currentQ.right});
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {1, 2, 3};
        TreeNode a1 = TreeNode.buildHelper(a);
        TreeNode b1 = TreeNode.buildHelper(a);
        Integer[] c = {1, 2};
        Integer[] d = {1, null, 2};
        TreeNode c1 = TreeNode.buildHelper(c);
        TreeNode d1 = TreeNode.buildHelper(d);
        Integer[] e = {1, 2, 1};
        Integer[] f = {1, 1, 2};
        TreeNode e1 = TreeNode.buildHelper(e);
        TreeNode f1 = TreeNode.buildHelper(f);

        System.out.println(sameTreeRecursive(a1, b1));
        System.out.println(sameTreeRecursive(c1, d1));
        System.out.println(sameTreeRecursive(e1, f1));
        System.out.println(sameTreeIterative(a1, b1));
        System.out.println(sameTreeIterative(c1, d1));
        System.out.println(sameTreeIterative(e1, f1));
    }
}
