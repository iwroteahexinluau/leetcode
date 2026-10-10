/* https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * 24. Swap Nodes in Pairs
 *
 * We can use a dummy node to access the first node easily without needing a special
 * case. We keep track of three pointers, prev, and the first and second nodes that are
 * being swapped in the pair. For each pair, we update the next references to reverse the
 * pair and set prev.next to the second node to reconnect the chain.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode firstNode = prev.next;
            ListNode secondNode = prev.next.next;

            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prev.next = secondNode;

            prev = firstNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        ListNode a1 = ListNode.buildHelper(a);
        int[] b = {};
        ListNode b1 = ListNode.buildHelper(b);
        int[] c = {1};
        ListNode c1 = ListNode.buildHelper(c);
        int[] d = {1, 2, 3};
        ListNode d1 = ListNode.buildHelper(d);

        System.out.println(swapPairs(a1));
        System.out.println(swapPairs(b1));
        System.out.println(swapPairs(c1));
        System.out.println(swapPairs(d1));
    }
}
