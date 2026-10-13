/* https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 * 160. Intersection of Two Linked Lists
 *
 * We can find the intersection by indepedently moving a pointer through each linked
 * list. Once a pointer reaches the end of the linked list, we set it to the start of the
 * other list. Since both pointers will travel the length of A + B through two
 * passes, they are guaranteed to reach the intersection if there is one on one of
 * the two passes. If there is no intersection, the pointers will both become null at the
 * same time after both traversals.
 *
 * Time O(m + n), Space O(1)
 * m = length of headA
 * n = length of headB
 */

class Solution {
    public static ListNode intersectionOfTwoLists(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }
            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }

        return a;
    }

    public static void main(String[] args) {
        ListNode shared = ListNode.buildHelper(new int[]{8, 4, 5});
        ListNode headA = ListNode.buildHelper(new int[]{4, 1});
        ListNode headB = ListNode.buildHelper(new int[]{5, 6, 1});
        headA.next.next = shared;
        headB.next.next.next = shared;
        System.out.println(intersectionOfTwoLists(headA, headB));

        ListNode a2 = ListNode.buildHelper(new int[]{1, 2, 3});
        ListNode b2 = ListNode.buildHelper(new int[]{4, 5, 6});
        System.out.println(intersectionOfTwoLists(a2, b2));

        ListNode head = ListNode.buildHelper(new int[]{1, 2, 3});
        System.out.println(intersectionOfTwoLists(head, head));
    }
}
