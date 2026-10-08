class Solution {
    public static ListNode reverseList(ListNode head) {
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

        System.out.println(reverseList(a1));
        System.out.println(reverseList(b1));
    }
}
