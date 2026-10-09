/* https://leetcode.com/problems/reverse-linked-list/description/
 * 206. Reverse Linked List
 *
 * Iterative Solution:
 * We can use two pointers to keep track of the previous node and the current node. The
 * previous node starts at null and we set the current node to point to the previous node
 * before iterating to the next node setting prev to current. Once current = null, we
 * have reached the end of the list and return prev, which will be the last non null
 * node.
 *
 * Time O(n), Space O(1)
 *
 * Recursive Solution:
 * We can recurse through the linked list to the find the last node. At each recursive
 * level, we set head.next.next = head making the next node point backward to the current
 * node. We then set head.next = null to remove where head was pointing to original. Then
 * we return the new head.
 *
 * Time O(n), Space O(n)
 *
 */

class Solution {
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // temp keeps track of the new head node
        ListNode temp = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    // iterative solution
    public static ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode a1 = ListNode.buildHelper(a);
        int[] b = {1, 2};
        ListNode b1 = ListNode.buildHelper(b);
        ListNode a2 = ListNode.copyOf(a1);
        ListNode b2 = ListNode.copyOf(b1);

        System.out.println(reverseListIterative(a1));
        System.out.println(reverseListIterative(b1));
        System.out.println(reverseListRecursive(a2));
        System.out.println(reverseListRecursive(b2));
    }
}
