/* ListNode
 *
 * My Linked List data structure that follows the documentation of the Leetcode ListNode
 * class. The easiest way to create a ListNode is by using the buildHelper method on
 * an int[] array exactly like how Leetcode displays the Linked List test cases.
 *
 * Also contains the methods toString and copyOf.
 *
 */

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildHelper(int[] input) {
        if (input.length == 0) {
            return null;
        }

        ListNode node = new ListNode(input[0]);
        ListNode front = node;

        for (int i = 1; i < input.length; i++) {
            ListNode newNode = new ListNode(input[i]);
            node.next = newNode;
            node = newNode;
        }

        return front;
    }

    public static ListNode copyOf(ListNode source) {
        if (source == null) {
            return null;
        }

        return new ListNode(source.val, copyOf(source.next));
    }

    @Override
    public String toString() {
        StringBuilder printString = new StringBuilder("[");
        ListNode current = this;
        while (current != null) {
            printString.append(current.val);
            if (current.next != null) {
                printString.append(", ");
            }
            current = current.next;
        }
        printString.append("]");
        return printString.toString();
    }
            
}
