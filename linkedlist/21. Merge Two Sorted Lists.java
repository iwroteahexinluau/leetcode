/* https://leetcode.com/problems/merge-two-sorted-lists/description/
 * 21. Merge Two Sorted Lists
 *
 * We can create a dummy node and then compare the current values of list1 and list2
 * attaching the smaller node to the merged list. Then we advance the pointer of the list
 * that added the node. Once we reach the end of one list, we append the remaining
 * portion of the other list if possible.
 *
 * Time O(n + m), Space O(1)
 */

class Solution {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current = new ListNode();
        ListNode start = current;
        while(list1 != null && list2 != null) {
            int i = list1.val;
            int j = list2.val;
            if (i <= j) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        return start.next;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4}, b = {1, 3, 4};
        ListNode a1 = ListNode.buildHelper(a);
        ListNode b1 = ListNode.buildHelper(b);
        ListNode c1 = null;
        ListNode d1 = null;
        ListNode e1 = null;
        ListNode f1 = new ListNode(0);
        System.out.println(mergeTwoLists(a1, b1));
        System.out.println(mergeTwoLists(c1, d1));
        System.out.println(mergeTwoLists(e1, f1));
    }
}
